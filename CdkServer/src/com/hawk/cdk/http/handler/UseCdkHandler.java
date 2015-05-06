package com.hawk.cdk.http.handler;

import java.io.IOException;
import java.util.Map;

import org.hawk.util.services.HawkCdkService;

import net.sf.json.JSONObject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.hawk.cdk.Cdk;
import com.hawk.cdk.CdkServices;
import com.hawk.cdk.http.CdkHttpServer;
import com.hawk.cdk.http.param.UseCdkParam;

/**
 * cdk使用处理
 * 
 * @author hawk
 */
public class UseCdkHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		int status = HawkCdkService.CDK_STATUS_NONEXIST;
		JSONObject jsonObject = new JSONObject();

		Map<String, String> params = CdkHttpServer.parseHttpParam(httpExchange);
		Cdk.checkToken(params.get("token"));
		
		UseCdkParam cdkparam = new UseCdkParam();
		if (cdkparam.initParam(params)) {
			cdkparam.toLowerCase();
			status = CdkServices.getInstance().useCdk(cdkparam);
		}

		jsonObject.put("status", String.valueOf(status));
		if (status == HawkCdkService.CDK_STATUS_OK) {
			jsonObject.put("reward", cdkparam.getReward());
		}

		CdkHttpServer.response(httpExchange, jsonObject);
	}
}
