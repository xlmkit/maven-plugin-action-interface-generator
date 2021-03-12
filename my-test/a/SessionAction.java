package a;

import com.xlmkit.springext.Result;
import lombok.Getter;
import lombok.Data;
import javax.servlet.http.*;
import java.lang.Object;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import java.util.Map;
import java.util.Date;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import javax.validation.Valid;

/**
 * 
 * 
 *
 */
public interface SessionAction {
	/**
	*LoginBody
	*/
    @lombok.Data
public static class LoginBody {
private null loginName;
private null codeToken;
private null password;
}

	/**
	 * 
	 */
	Result
 login 	(
		LoginBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*SendSmsCodeBody
	*/
    @lombok.Data
public static class SendSmsCodeBody {
private null telephone;
}

	/**
	 * 
	 */
	Result
 sendSmsCode 	(
		SendSmsCodeBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*ActivateBody
	*/
    @lombok.Data
public static class ActivateBody {
private null code;
}

	/**
	 * 
	 */
	Result
 activate 	(
		ActivateBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*InfoBody
	*/
    @lombok.Data
public static class InfoBody {
}

	/**
	 * 
	 */
	Result
 info 	(
		InfoBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*LoginByTelBody
	*/
    @lombok.Data
public static class LoginByTelBody {
private null telephone;
private null codeToken;
}

	/**
	 * 
	 */
	Result
 loginByTel 	(
		LoginByTelBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*ImageCodeBody
	*/
    @lombok.Data
public static class ImageCodeBody {
private null name;
}

	/**
	 * 
	 */
	Result
 imageCode 	(
		ImageCodeBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*UpdatePwdBody
	*/
    @lombok.Data
public static class UpdatePwdBody {
private null oldPassword;
private null password;
}

	/**
	 * 
	 */
	Result
 updatePwd 	(
		UpdatePwdBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*FeedbackBody
	*/
    @lombok.Data
public static class FeedbackBody {
private null telephone;
private null type;
private null content;
private null images;
}

	/**
	 * 
	 */
	Result
 feedback 	(
		FeedbackBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*RegisterBody
	*/
    @lombok.Data
public static class RegisterBody {
private null name;
private null sex;
private null telephone;
private null codeToken;
private null password;
}

	/**
	 * 
	 */
	Result
 register 	(
		RegisterBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*UpdateInfoBody
	*/
    @lombok.Data
public static class UpdateInfoBody {
private null name;
private null sex;
}

	/**
	 * 
	 */
	Result updateInfo(UpdateInfoBody body) throws com.xlmkit.springext.sdk.SDKException;
}
