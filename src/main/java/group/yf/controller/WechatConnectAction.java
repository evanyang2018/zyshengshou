package group.yf.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import group.yf.util.EncryptionUtil;





/**
 * 建立微信连接类
 * @author Yang Fei
 *
 */
@Controller
public class WechatConnectAction {

	private Logger log = Logger.getLogger(this.getClass());
	@Resource(name="wechatConfig")
	private Properties wechatConfig;

	/**
	 * 微信端 连接测试类
	 */
	@ResponseBody
	@RequestMapping(value="/wechartConnet",
			method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String wechartConnet(HttpServletRequest req,
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {

		log.info("接收到微信服务器参数>>signature>>"+signature+">>>timestamp>>"+timestamp+">>>nonce>>"+nonce+">>>echostr>>"+echostr);
		log.info("配置文件的token>>>" + wechatConfig.getProperty("token"));
		// 1.将token、timestamp、nonce三个参数进行字典序排序
		String[] param = new String[] { wechatConfig.getProperty("token"), timestamp, nonce };
		Arrays.sort(param);
		// 2.将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer paramBuffer = new StringBuffer();
		for (int i = 0; i < param.length; i++) {
			paramBuffer.append(param[i]);
		}
		String result = "";
		try {
			result = EncryptionUtil.getSHA1(paramBuffer.toString());
		} catch (NoSuchAlgorithmException e) {
			log.error("获取SHA1加密失败");
			return "";
		}
		// 3.开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if (signature.equals(result)) {
			log.info("验证成功，与微信服务器的连接成功！");
			return echostr;
		} else {
			log.error("验证失败，与微信服务器连接失败！");
			return "";
		}
	}

	/**
	 * 微信消息推送类
	 */
	@ResponseBody
	@RequestMapping(value="/wechartConnet",
			method=RequestMethod.POST,produces = "application/xml;charset=UTF-8")
	public String wechartConnet(HttpServletRequest request) {
		log.info("获取到微信端消息推送");
		return "";
	}

}
