/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nolanofra.app.test.ViewFlipperSlidingDrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class ViewFlipperSlidingDrawer extends Activity{
	
	private ViewFlipper flipper;  
    private float oldTouchValue;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        this.flipper = (ViewFlipper)findViewById(R.id.flipper);
        
        Animation s_in  = AnimationUtils.loadAnimation(this, R.anim.slidein);
        Animation s_out = AnimationUtils.loadAnimation(this, R.anim.slideout);
        this.flipper.setInAnimation(s_in);
        this.flipper.setOutAnimation(s_out);
	}
	
	 @Override
	    public boolean onTouchEvent(MotionEvent touchevent) {
	        switch (touchevent.getAction())
	        {
	            case MotionEvent.ACTION_DOWN:
	            {
	                oldTouchValue = touchevent.getX();
	                break;
	            }
	            case MotionEvent.ACTION_UP:
	            {
	                //if(this.searchOk==false) return false;
	                float currentX = touchevent.getX();
	                if (oldTouchValue < currentX)
	                {
	                    
	                    flipper.showNext();
	                }
	                if (oldTouchValue > currentX)
	                {
	              
	                    flipper.showPrevious();
	                }
	            break;
	            }
	        }
	        return false;
	    }

}
