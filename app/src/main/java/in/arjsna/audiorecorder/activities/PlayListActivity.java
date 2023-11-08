package in.arjsna.audiorecorder.activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import in.arjsna.audiorecorder.R;
import in.arjsna.audiorecorder.mvpbase.BaseActivity;
import in.arjsna.audiorecorder.playlist.PlayListFragment;
import javax.inject.Inject;

public class PlayListActivity extends BaseActivity {

  @Inject
  DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_record_list);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(R.string.tab_title_saved_recordings);
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setDisplayShowHomeEnabled(true);
    }
    setNavBarColor();

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.record_list_container, PlayListFragment.newInstance())
          .commit();
    }
  }

//  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
//    return dispatchingAndroidInjector;
//  }
}
