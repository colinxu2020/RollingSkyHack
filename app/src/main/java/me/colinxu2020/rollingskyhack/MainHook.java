package me.colinxu2020.rollingskyhack;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam){
        //if(!lpparam.packageName.equals("com.turbochilli.rollingsky_cn.nearme.gamecenter"))return;
        XposedHelpers.findAndHookMethod("com.turbochilli.rollingsky.util.NativeUtil", lpparam.classLoader, "callPayCallback", String.class, int.class, int.class, new XC_MethodHook(){
            @Override
            protected void beforeHookedMethod(MethodHookParam param){
                param.args[1] = 100;
            }
        });
    }
}
