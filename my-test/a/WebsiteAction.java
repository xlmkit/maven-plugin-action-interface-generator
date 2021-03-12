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
public interface WebsiteAction {
	/**
	*ListBody
	*/
	@lombok.Data
	public static class ListBody {
	}

	/**
	 * 
	 */
	Result list(ListBody body) throws com.xlmkit.springext.sdk.SDKException;

	/**
	*GetMediaUrlBody
	*/
    @lombok.Data
public static class GetMediaUrlBody {
private null url;
}

	/**
	 * 
	 */
	Result
 getMediaUrl 	(
		GetMediaUrlBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*ToMediaUrlBody
	*/
    @lombok.Data
public static class ToMediaUrlBody {
private null url;
}

	/**
	 * 
	 */
	Result
 toMediaUrl 	(
		ToMediaUrlBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*ReadyParseMediaUrlBody
	*/
    @lombok.Data
public static class ReadyParseMediaUrlBody {
private null url;
}

	/**
	 * 
	 */
	Result
 readyParseMediaUrl 	(
		ReadyParseMediaUrlBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*VideoPlayBody
	*/
    @lombok.Data
public static class VideoPlayBody {
private null videoId;
private null guid;
private null ipInfo;
private null ip;
private null currentTime;
private null duration;
}

	/**
	 * 
	 */
	Result videoPlay(VideoPlayBody body) throws com.xlmkit.springext.sdk.SDKException;
}
