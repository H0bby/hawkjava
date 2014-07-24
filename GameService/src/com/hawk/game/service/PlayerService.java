package com.hawk.game.service;

import org.hawk.app.HawkAppObj;
import org.hawk.msg.HawkMsg;
import org.hawk.net.protocol.HawkProtocol;

import com.hawk.game.player.GsPlayer;
import com.hawk.game.service.GameService;

/**
 * ��ҷ���
 * 
 * @author hawk
 */
public class PlayerService extends GameService {
	/**
	 * Э�鴦��
	 */
	@Override
	public boolean onProtocol(GsPlayer player, HawkProtocol protocol) {
		if (protocol != null) {
			player.sendProtocol(protocol);
			return true;
		}
		return false;
	}

	/**
	 * ��Ϣ����
	 */
	@Override
	public boolean onMessage(HawkAppObj appObj, HawkMsg msg) {
		return false;
	}
}
