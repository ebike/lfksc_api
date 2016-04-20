package com.lfksc.api.util;

import org.apache.log4j.Logger;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushUtil
{
	private static Logger logger = Logger.getLogger(PushUtil.class);
	
	/**
	 * 推送安卓通知
	 * @param clientId
	 * @param eventType
	 * @param msg
	 */
	public static void pushAndroidNotification(String clientId, int eventType, String title, String msg)
	{
		String masterSecret = "b18661e4443a4562ae9e3c6c";
		String appKey = "c9d26b53ef983b13800a1300";
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		PushPayload payload = buildPushAndroidNotification(clientId, eventType, title, msg);
		try
		{
			PushResult result = jpushClient.sendPush(payload);
			logger.warn("android-clientId："+clientId);
			logger.warn("android-推送结果："+result);
		}
		catch (APIConnectionException e)
		{
		}
		catch (APIRequestException e)
		{
		}
	}
	
	/**
	 * 创建安卓通知消息对象
	 * @param clientId
	 * @param eventType
	 * @param msg
	 * @return
	 */
	public static PushPayload buildPushAndroidNotification(String clientId, int eventType, String title, String msg)
	{
		return PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.alias(clientId))
				.setNotification(
						Notification.newBuilder()
                        .addPlatformNotification(
                        		AndroidNotification.newBuilder()
                                .setAlert(msg)
                                .setTitle(title)
                                .addExtra("eventType", eventType)
                                .build()).build()
				).build();
	}
	
	/**
	 * 推送苹果通知
	 * @param clientId
	 * @param eventType
	 * @param msg
	 */
	public static void pushIOSNotification(String clientId, int eventType, String msg)
	{
		String masterSecret = "b18661e4443a4562ae9e3c6c";
		String appKey = "c9d26b53ef983b13800a1300";
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		PushPayload payload = buildPushIOSNotification(clientId, eventType, msg);
		try
		{
			PushResult result = jpushClient.sendPush(payload);
			logger.warn("ios-clientId："+clientId);
			logger.warn("ios-推送结果："+result);
		}
		catch (APIConnectionException e)
		{
		}
		catch (APIRequestException e)
		{
		}
	}
	
	/**
	 * 创建苹果通知消息对象
	 * @param clientId
	 * @param eventType
	 * @param msg
	 * @return
	 */
	public static PushPayload buildPushIOSNotification(String clientId, int eventType, String msg)
	{
		return PushPayload.newBuilder()
        .setPlatform(Platform.ios())
        .setAudience(Audience.alias(clientId))
        .setNotification(Notification.newBuilder()
                .addPlatformNotification(IosNotification.newBuilder()
                        .setAlert(msg)
                        .setSound("msg_prompt.mp3")
                        .addExtra("eventType", eventType)
                        .build())
                .build())
         .setMessage(Message.content(msg))
         .setOptions(Options.newBuilder()
                 .setApnsProduction(true)
                 .build())
         .build();
	}
	
	/**
	 * 推送消息方法
	 * @param clientId
	 * @param eventType
	 * @param msg
	 */
	public static void pushMsg(String clientId, int eventType, String msg)
	{
		String masterSecret = "b18661e4443a4562ae9e3c6c";
		String appKey = "c9d26b53ef983b13800a1300";
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		PushPayload payload = buildPushObject(clientId, eventType, msg);
		try
		{
			PushResult result = jpushClient.sendPush(payload);
			logger.warn("clientId："+clientId);
			logger.warn("推送结果："+result);
		}
		catch (APIConnectionException e)
		{
		}
		catch (APIRequestException e)
		{
		}
	}
	
	/**
	 * 创建PushPayLoad对象
	 * 
	 * @param clientId
	 * @param eventType
	 * @param msg
	 * @return
	 */
	public static PushPayload buildPushObject(String clientId, int eventType, String msg)
	{
		return PushPayload.newBuilder()
        .setPlatform(Platform.android_ios())
        .setAudience(Audience.alias(clientId))
        .setMessage(Message.newBuilder().setMsgContent(msg).addExtra("eventType", eventType).build())
        .build();
    }

}
