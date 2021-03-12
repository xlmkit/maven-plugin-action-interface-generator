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
public interface MapShareAction {
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
	Result
 page 	(
		PageBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*SetBody
	*/
    @lombok.Data
public static class SetBody {
private null longitude;
private null latitude;
private null mapShare;
private null locationName;
}

	/**
	 * 
	 */
	Result
 set 	(
		SetBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*SearchBody
	*/
    @lombok.Data
public static class SearchBody {
private null x;
private null y;
private null x2;
private null y2;
}

	/**
	 * 
	 */
	Result
 search 	(
		SearchBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*RecommendedListBody
	*/
    @lombok.Data
public static class RecommendedListBody {
}

	/**
	 * 
	 */
	Result
 recommendedList 	(
		RecommendedListBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*RandomAccessBody
	*/
    @lombok.Data
public static class RandomAccessBody {
private null ignoreId;
}

	/**
	 * 
	 */
	Result
 randomAccess 	(
		RandomAccessBody body
		) throws com.xlmkit.springext.sdk.SDKException ;

	/**
	*UserListBody
	*/
    @lombok.Data
public static class UserListBody {
private null userId;
}

	/**
	 * 
	 */
	Result userList(UserListBody body) throws com.xlmkit.springext.sdk.SDKException;
}
