package com.zhangqi.autohomerefreshlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;


public class MainActivity extends Activity {

  private SeekBar mSeekBar;
  private AutoHome mAutoHome;
  private float mCurrentProgress;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      mSeekBar = (SeekBar) findViewById(R.id.seekbar);
      mAutoHome = (AutoHome) findViewById(R.id.autohome);

      mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
              mCurrentProgress = (float)seekBar.getProgress()/(float)seekBar.getMax();
              mAutoHome.setCurrentProgress(mCurrentProgress);
              mAutoHome.invalidate();
          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });
  }


}
