package com.zgtech.funplay.asyn;

import android.os.AsyncTask;

import com.zgtech.funplay.model.ChargeModel;

/**
 * AsyncTask prac
 * Created by Administrator on 2017/11/17.
 */

public class NetAsyncTask extends AsyncTask{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Object doInBackground(Object[] params) {
        ChargeModel chargeModel = new ChargeModel();

        return chargeModel;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

    }
}
