package com.lfksc.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author 吴鹏 
 */
public class Util
{
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str)
	{
		if (str != null && !"".equals(str))
		{
			return false;
		}
		return true;
	}
	
	//将字符串转化为日期格式
	public static Date formateDate(String format, String dateString)
			throws ParseException
	{
		if (!"".equals(dateString))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(dateString);
		}
		else
		{
			return null;
		}
	}
	
	//将日期转化为字符串
	public static String formatDateToStr(String format,Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
	}
	
	//当前时间增加一个月
	public static Date addOneMoth()throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+2;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(year).append("-").append(month).append("-").append(day).append(" ").append(hour).append(":").append(min).append(":").append(s);
		return Util.formateDate("yyyy-MM-dd HH:mm:ss", buffer.toString());
	}
	
	//为指定日期增加指定的年数
	public static Date addSomeYear(String date,int year)throws Exception
	{
		String[] dateStrings = date.split("-");
		StringBuffer buffer = new StringBuffer();
		int nyear = Integer.valueOf(dateStrings[0]).intValue()+year;
		buffer.append(nyear).append("-").append(dateStrings[1]).append("-").append(dateStrings[2]);
		return Util.formateDate("yyyy-MM-dd", buffer.toString());
	}
	
	//为指定日期增加指定的月数
	public static Date addSomeMonth(String date,int month)throws Exception
	{
		String[] dateStrings = date.split("-");
		StringBuffer buffer = new StringBuffer();
		int nmonth = Integer.valueOf(dateStrings[1]).intValue()+month;
		buffer.append(dateStrings[0]).append("-").append(nmonth).append("-").append(dateStrings[2]);
		return Util.formateDate("yyyy-MM-dd", buffer.toString());
	}
	
	//为指定日期减少指定的月数
	public static Date subSomeMoth(String date,int month)throws Exception
	{
		String[] dateStrings = date.split("-");
		StringBuffer buffer = new StringBuffer();
		int nmonth = Integer.valueOf(dateStrings[1]).intValue()+month;
		buffer.append(dateStrings[0]).append("-").append(nmonth).append("-").append(dateStrings[2]);
		return Util.formateDate("yyyy-MM-dd", buffer.toString());
	}
	
	/**
	 * 在时间加上指定的分钟数
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addSomeMinute(Date date, int minute)
	{
		return new Date(date.getTime() + minute*60*1000);
	}
	
	/** 
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return  
     */  
    public static String subZeroAndDot(String s)
    {  
        if(s.indexOf(".") > 0)
        {  
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }  
        return s;  
    }  
	
	/**
	 * 根据毫秒数转换为 *天*时*分*秒的格式
	 * @param millisecond
	 * @return
	 */
	public static String formatMillisecond(long millisecond)
	{
		//计算出相差天数
		double days = Math.floor(millisecond/(24*3600*1000));
		 
		//计算出小时数
		long leave1 = millisecond%(24*3600*1000); //计算天数后剩余的毫秒数
		double hours = Math.floor(leave1/(3600*1000));

		//计算相差分钟数
		long leave2 = leave1%(3600*1000);         //计算小时数后剩余的毫秒数
		double minutes = Math.floor(leave2/(60*1000));
		
		//计算相差秒数
		long leave3 = leave2%(60*1000);           //计算分钟数后剩余的毫秒数
		double seconds = Math.round(leave3/1000);
		
		StringBuffer sBuffer = new StringBuffer("");
		if(days > 0)
		{
			sBuffer.append(Util.subZeroAndDot(String.valueOf(days))).append("天");
		}
		if(hours > 0)
		{
			sBuffer.append(Util.subZeroAndDot(String.valueOf(hours))).append("小时");
		}
		if(minutes > 0)
		{
			sBuffer.append(Util.subZeroAndDot(String.valueOf(minutes))).append("分钟");
		}
		if(seconds > 0)
		{
			sBuffer.append(Util.subZeroAndDot(String.valueOf(seconds))).append("秒");
		}
		if("".equals(sBuffer.toString()))
		{
			return "小于1秒";
		}
		return sBuffer.toString();
	}
	
	/**
	 *
	 +--------------------------------------------------------------------
	 * Description 友好显示时间
	 +--------------------------------------------------------------------
	 * @param long time 要格式化的时间戳
	 +--------------------------------------------------------------------
	 * @return String txt 格式化后的时间戳
	 +--------------------------------------------------------------------
	 * @author ernest
	 +--------------------------------------------------------------------
	 */
	public static String friendlyShowTime(long time)
	{
		long nowTime = new Date().getTime();
	    String txt = "";
	    long t = nowTime - time; //时间差（毫秒）
	    if (t <= 0)
	    {
	        txt = "刚刚";
	    }
	    else if (t < 60*1000)
	    {
	    	txt = t/1000 + "秒前"; // 一分钟内
	    }
	    else if (t < 60 * 60 * 1000)
	    {
	    	String s = subZeroAndDot(String.valueOf(Math.floor(t/(60*1000))));
	    	txt = s + "分钟前"; //一小时内
	    }
	    else if (t < 60 * 60 * 24 * 1000)
	    {
	    	String s = subZeroAndDot(String.valueOf(Math.floor(t/(60*60*1000))));
	    	txt = s + "小时前"; // 一天内
	    }
	    else if (t < 60 * 60 * 24 * 3 * 1000)
	    {
	        String date = formatDateToStr("HH:mm", new Date(time));
	    	txt = Math.floor(time/(60*60*24*1000)) == 1 ? "昨天"+date : "前天 "+date ; //昨天和前天
	    }
	    else if (t < 60 * 60 * 24 * 30 * 1000)
	    {
	    	txt = formatDateToStr("MM月dd日 HH:mm", new Date(time)); //一个月内
	    }
	    else if (t < 60 * 60 * 24 * 365 * 1000)
	    {
	    	txt = formatDateToStr("MM月dd日", new Date(time)); //一年内
	    }
	    else
	    {
	    	txt = formatDateToStr("yyyy年MM月dd日", new Date(time));//一年以前
	    }
	    return txt;
	}
	
	/**
	 * 删除文件功能
	 * @param f 文件路径
	 */
	public static void deleteFile(String f)
	{
		File file = new File(f);
		//是否存在
		if(file.exists())
		{
			file.delete();
		}
	}
	//上传文件判断大小
	public static long getFileSize(String distFilePath)
	{
		File distFile = new File(distFilePath);
		if (distFile.isFile())
		{
			return distFile.length();
		} else if (distFile.isDirectory())
		{
			return FileUtils.sizeOfDirectory(distFile);
		}
		return -1L;
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	public static String sendHtmlWriter(HttpServletResponse response, String message)
	{
		try
		{
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(message);
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	public static String sendJsonWriter(HttpServletResponse response, String message)
	{
		try
		{
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(message);
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String returnSixDecimal(int a, int b)
	{
		float num= (float)a/b;
		DecimalFormat df = new DecimalFormat("0.000000");//格式化小数   
		String str = df.format(num);//返回的是String类型 
		return str;
	}
	
	/**
	 * 根据航向返回反向
	 * @param heading
	 * @return
	 */
	public static String directionStr(short heading)
	{
		String d = "";
		if(heading > 22.5 && heading <= 67.5)
		{
			d = "东北方向";
		}
		if(heading > 67.5 && heading <= 112.5)
		{
			d = "正北方向";
		}
		if(heading > 112.5 && heading <= 157.5)
		{
			d = "东南方向";
		}
		if(heading > 157.5 && heading <= 202.5)
		{
			d = "正南方向";
		}
		if(heading > 202.5 && heading <= 247.5)
		{
			d = "西南方向";
		}
		if(heading > 247.5 && heading <= 292.5)
		{
			d = "正西方向";
		}
		if(heading > 292.5 && heading <= 337.5)
		{
			d = "西北方向";
		}
		if(heading > 337.5 || heading <= 22.5)
		{
			d = "正北方向";
		}
		return d;
	}
	
	/**
	 * 调用Http接口返回Json结果
	 * @param httpUrl
	 * @return
	 */
	public static JSONObject returnHttpJson(String httpUrl)
	{
		StringBuilder json = new StringBuilder();
		try
		{
			URL reqURL = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) reqURL.openConnection();
			
			// 取得该连接的输入流，以读取响应内容
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String inputLine = null;
			while ((inputLine = bufferedReader.readLine()) != null)
			{
				json.append(inputLine);
			}
			bufferedReader.close();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			JSONObject infoJson = new JSONObject(json.toString());
			return infoJson;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * 获取去掉横线的UUID
	 * @return
	 */
	public static String getUUID()
	{
		UUID uuid  =  UUID.randomUUID();
		return uuid.toString().replaceAll("\\-", "");
	}
	
	/**
	 * 根据经纬度，获取两点间的距离(单位：米)
	 * @param aLng
	 * @param aLat
	 * @param bLng
	 * @param bLat
	 * @return
	 */
	public static double distanceByTwoPoint(double aLng, double aLat, double bLng, double bLat)
	{
		double radALat = aLat * Math.PI / 180;
		double radBLat = bLat * Math.PI / 180;
		double a = radALat - radBLat;
		double b = aLng * Math.PI / 180 - bLng * Math.PI / 180;
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radALat) * Math.cos(radBLat) * Math.pow(Math.sin(b / 2), 2)));
		distance = distance * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		//distance = Math.round(distance * 10000) / 10000;
		return distance;
	}
	
	/**
	 * 保留一位小数
	 * @param distance
	 * @return
	 */
	public static double converOneDecimal(double num)
	{
		DecimalFormat df = new DecimalFormat(".#");
		String numStr = df.format(num);
		return Double.valueOf(numStr).doubleValue();
	}
	
	/**
	 * 将米转换为公里保留一位小数
	 * @param distance
	 * @return
	 */
	public static double covertDistanceKm(double distance)
	{
		DecimalFormat df = new DecimalFormat(".#");
		String disStr = df.format(distance/1000);
		return Double.valueOf(disStr).doubleValue();
	}
	
	/**
	 * 根据距离返回两位小数千米或米的字符串
	 * @param distance
	 * @return
	 */
	public static String convertDistanceShow(double distance)
	{
		DecimalFormat df = new DecimalFormat(".##");
		String str = df.format(distance)+"米";
		if (distance > 1000)
		{
			str = df.format(distance/1000)+"千米";
		}
		return str;
	}
	
}
