package jwb.aha.address.util;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 날짜를 제어하는 헬퍼 함수들
 *
 * @author JWB
 */
public class DateUtil {
	
	/** 변환에 사용되는 날짜 패턴이다. 원하는 대로 바꿔도 좋다. */
	private static final String DATETIME_PATTERN = "yyyy.MM.dd.HH.mm.ss";
	
	/** 날짜 변환기 */
	private static final DateTimeFormatter DATETIME_FORMATTER = 
			DateTimeFormatter.ofPattern(DATETIME_PATTERN);

	/**
     * 주어진 날짜를 String 타입으로 반환한다. 위에서 정의한
     * {@link DateUtil#DATETIME_PATTERN}이 사용된다.
     *
     * @param date the date to be returned as a string
     * @return formatted string
     */
	
	public static String format(LocalDateTime dateTime) {
		if(dateTime == null) {
			return null;
		}
		return DATETIME_FORMATTER.format(dateTime);
	}
	
	/**
     * String을 {@link DateUtil#DATETIME_PATTERN}에 정의한 대로
     * {@link LocalDate} 객체로 변환한다.
     *
     * String이 변환되지 않으면 null을 반환한다.
     *
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */
	
	public static LocalDateTime parse(String dateString) {
//		try {
			return DATETIME_FORMATTER.parse(dateString,LocalDateTime::from);
//		}catch(DateTimeException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
     * 유효한 날짜인지 검사한다.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
	public static boolean validDate(String dateString) {
    	// Try to parse the String.
    	return DateUtil.parse(dateString) != null;
    }
}
