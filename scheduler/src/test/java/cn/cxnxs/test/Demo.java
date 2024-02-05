package cn.cxnxs.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Demo {
    public static void main(String[] args) throws ScriptException {
        String str = "1>0";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(str);
        System.out.println(result);
    }
}
