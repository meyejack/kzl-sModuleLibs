package com.kzl.lib.http.client.impl.async;

import android.content.Context;

import com.kzl.lib.http.client.callback.IHttpExecute;
import com.kzl.lib.http.client.interfaces.IAsyncHttpClient;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseFilter;
import com.kzl.lib.http.client.interfaces.callback.IHttpResponseHandler;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpRequest;
import com.kzl.lib.http.client.interfaces.model.EmptyHttpResponse;
import com.kzl.lib.http.client.utils.AsyncHttpUtil;

import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;

/**
 * Created by Administrator on 14-4-17.
 * 通过AsyncTask实现的post异步请求
 */
public class PostImplAsyncHttpClient<T extends EmptyHttpResponse> implements IAsyncHttpClient<T> {
    @Override
    public void execute(Context context, final String requestUrl, EmptyHttpRequest request, Class<T> classOfT, IHttpResponseHandler<T> handler, IHttpResponseFilter filter) {
        AsyncHttpUtil.execute(classOfT, handler, new IHttpExecute() {
            @Override
            public HttpResponse execute() {
                return HttpUtils.httpPost(requestUrl);
            }
        }, filter);
    }
}
