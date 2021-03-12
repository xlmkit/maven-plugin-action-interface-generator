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
public interface CollectionAction {
	/**
	*CreateBody
	*/
    @lombok.Data
public static class CreateBody {
private null url;
private null title;
}

	/**
	 * 
	 */
	Result
 create 	(
		CreateBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*RemoveBody
	*/
    @lombok.Data
public static class RemoveBody {
private null id;
}

	/**
	 * 
	 */
	Result
 remove 	(
		RemoveBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*PageBody
	*/
    @lombok.Data
public static class PageBody {
private null pageNumber;
private null pageSize;
private null keyword;
private null keyword_type;
}

	/**
	 * 
	 */
	Result page(PageBody body) throws com.xlmkit.springext.sdk.SDKException;
}
