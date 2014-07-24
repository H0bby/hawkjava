package com.hawk.cdk.http.param;

import java.util.Map;

import org.hawk.os.HawkException;

import com.hawk.cdk.CdkServices;

/**
 * cdk删除类型参数
 * 
 * @author hawk
 */
public class DelTypeParam {
	public String game;
	public String type;

	public void toLowerCase() {
		if (game != null) {
			game.toLowerCase();
		}

		if (type != null) {
			type.toLowerCase();
		}
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean initParam(Map<String, String> params) {
		try {
			game = params.get("game");
			type = params.get("type");

			if (game.length() > CdkServices.CDK_HEADER_SIZE) {
				game = game.substring(0, CdkServices.CDK_HEADER_SIZE);
			}

			if (type.length() > CdkServices.CDK_HEADER_SIZE) {
				type = type.substring(0, CdkServices.CDK_HEADER_SIZE);
			}

		} catch (Exception e) {
			HawkException.catchException(e);
			return false;
		}
		return true;
	}
}
