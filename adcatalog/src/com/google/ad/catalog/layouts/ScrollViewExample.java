// Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.ad.catalog.layouts;

import com.google.ad.catalog.AdCatalogUtils;
import com.google.ad.catalog.LogAndToastAdListener;
import com.google.ad.catalog.R;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.os.Bundle;

/**
 * Example of a ScrollView with an AdMob banner.
 *
 * @author api.eleichtenschl@gmail.com (Eric Leichtenschlag)
 */
public class ScrollViewExample extends Activity {
  private AdView adView;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.scrollviewexample);

    adView = (AdView) findViewById(R.id.adView);
    adView.setAdListener(new LogAndToastAdListener(this));
    adView.loadAd(AdCatalogUtils.createAdRequest());
  }

  /** Overwrite the onDestroy() method to dispose of banners first. */
  @Override
  public void onDestroy() {
    if (adView != null) {
      adView.destroy();
    }
    super.onDestroy();
  }

}
