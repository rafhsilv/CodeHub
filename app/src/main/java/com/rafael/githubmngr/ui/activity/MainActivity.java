package com.rafael.githubmngr.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rafael.githubmngr.GithubMngrPrefs;
import com.rafael.githubmngr.R;
import com.rafael.githubmngr.bean.User;
import com.rafael.githubmngr.present.MainPresent;
import com.rafael.githubmngr.present.SettingPresent;
import com.rafael.githubmngr.present.ui.MainUi;
import com.rafael.githubmngr.present.ui.SettingUi;
import com.rafael.githubmngr.ui.fragment.EventsFragment;
import com.rafael.githubmngr.ui.fragment.RepositoryPagesFragment;
import com.rafael.githubmngr.utils.AvatarUrlUtil;
import com.rafael.githubmngr.utils.CropCircleTransformation;
import com.rafael.lib.utils.AppManager;
import com.rafael.lib.utils.ToastUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends BaseGithubMngrToolBarActivity implements MainUi, SettingUi, DialogInterface.OnClickListener {

    @Bind(R.id.img_navigation_avatar)
    ImageView mNavigationAvatarImageView;
    @Bind(R.id.tv_navigation_username)
    TextView mNavigationUsernameTextView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private ProgressDialog mLogoutLoadingDialog;
    private AlertDialog mLogoutConfirmDialog;
    private SettingPresent mSettingPresent;

    private User mUser;

    private Fragment mCurrentShowFragment;
    private RepositoryPagesFragment mRepositoryPagesFragment;
    private EventsFragment mEventsFragment;
    private MainPresent mMainPresent;

    public static Intent newIntent(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        return intent;
    }

    @Override
    protected void handleIntent(Intent intent) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        mDrawerLayout.setDrawerListener(toggle);
        mMainPresent = new MainPresent(this);

        mLogoutConfirmDialog = new AlertDialog.Builder(this).
                setMessage(R.string.wether_logout).
                setPositiveButton(getString(R.string.ok), this).
                setNegativeButton(getString(R.string.cancel), null).
                create();
        mLogoutLoadingDialog = new ProgressDialog(this);
        mLogoutLoadingDialog.setMessage(getString(R.string.loginout));
        mLogoutLoadingDialog.setProgressStyle(R.style.AppCompatAlertDialogStyle);
        mLogoutLoadingDialog.setCancelable(false);

        mSettingPresent = new SettingPresent(this);

        mRepositoryPagesFragment = new RepositoryPagesFragment();
        mEventsFragment = new EventsFragment();
        mEventsFragment.setUserVisibleHint(true);

        getSupportFragmentManager().beginTransaction().add(R.id.main_content, mRepositoryPagesFragment).commit();
        mCurrentShowFragment = mRepositoryPagesFragment;

        User user = GithubMngrPrefs.get().getUser();
        if (user == null) {
            mMainPresent.getUserInfo(GithubMngrPrefs.get().getToken(), GithubMngrPrefs.get().getUsername());
        }else {
            onGetUserInfoSuccess(user);
        }
    }

    @Override
    public void onGetUserInfoSuccess(User user) {
        mUser = user;
        GithubMngrPrefs.get().setUser(user);
        mNavigationUsernameTextView.setText(user.getLogin());
        Glide.with(MainActivity.this).load(AvatarUrlUtil.restoreAvatarUrl(user.getAvatar_url())).
                placeholder(R.drawable.ic_default_circle_head_image).diskCacheStrategy(DiskCacheStrategy.ALL).
                bitmapTransform(new CropCircleTransformation(MainActivity.this)).into(mNavigationAvatarImageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                startActivity(new Intent(this, SearchActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        mMainPresent.onDeath();
        mSettingPresent.onDeath();
        super.onDestroy();
    }

    @Override
    protected int getAttachLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.img_navigation_avatar)
    public void onUserOnClick() {
        if (mUser == null)  {
            ToastUtil.show(this, R.string.user_info_error);
            mMainPresent.getUserInfo(GithubMngrPrefs.get().getToken(),  GithubMngrPrefs.get().getUsername());
            return;
        }
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        Intent intent = UserInfoActivity.newIntent(this, mUser.getLogin());
        startActivity(intent);
    }

    @OnCheckedChanged(R.id.rb_repository)
    public void onRepositoryChecked(RadioButton radioButton, boolean isCheck) {
        if (isCheck) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            switchContent(mCurrentShowFragment, mRepositoryPagesFragment, R.id.main_content);
            mCurrentShowFragment = mRepositoryPagesFragment;
        }
    }

    @OnCheckedChanged(R.id.rb_event)
    public void onEventChecked(RadioButton radioButton, boolean isCheck) {
        if (isCheck) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            switchContent(mCurrentShowFragment, mEventsFragment, R.id.main_content);
            mCurrentShowFragment = mEventsFragment;
        }
    }

    @OnClick(R.id.rl_login_out)
    public void onLogoutClick() {
        mLogoutConfirmDialog.show();
    }


    public void switchContent(Fragment from, Fragment to, int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(id, to).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragments) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void logoutSuccess() {
        clearDataAndGotoLogin();
    }

    @Override
    public void showLogoutLoading(boolean isVisible) {

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            logout();
        }
    }

    private void clearDataAndGotoLogin() {
        GithubMngrPrefs.get().logout();
        AppManager.getInstance().finishAllActivity();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void logout() {
        String tokenId = GithubMngrPrefs.get().getTokenId();
        String baseUsernameAndPwd = GithubMngrPrefs.get().getBase64UsernameAndPwd();
        mSettingPresent.logout(baseUsernameAndPwd, tokenId);
        GithubMngrPrefs.get().logout();
    }
}
