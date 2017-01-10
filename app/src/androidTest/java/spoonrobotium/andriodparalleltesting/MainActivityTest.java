package spoonrobotium.andriodparalleltesting;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;

import com.robotium.solo.By;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

/**
 * Created by catalin on 10.01.2017.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;
    private boolean loaded = false;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    private void clickOnButton(){
        solo.clickOnButton(0);
        sleep(3);
        Log.d("WEBVIEW", "A fost incarcat");
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test001_passWriteNameInEditText() throws Exception {
        solo.clearEditText(0);
        solo.typeText(0, "Catalin Tudoroiu");

        sleep(1);
        Spoon.screenshot(getActivity(),"TypeNameInEditText");
    }

    public void test002_failWriteNameInEditText() throws Exception {
        solo.clearEditText(1);
    }

    public void test003_searchOnGoogle() throws Exception {
        clickOnButton();
        solo.waitForView(R.id.webview);
        solo.typeTextInWebElement(By.id("lst-ib"), "robotium and spoon ");
        solo.sendKey(KeyEvent.KEYCODE_ENTER);
        sleep(2);
        Spoon.screenshot(getActivity(),getName());
    }
}
