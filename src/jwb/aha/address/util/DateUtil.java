package jwb.aha.address.util;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ��¥�� �����ϴ� ���� �Լ���
 *
 * @author JWB
 */
public class DateUtil {
	
	/** ��ȯ�� ���Ǵ� ��¥ �����̴�. ���ϴ� ��� �ٲ㵵 ����. */
	private static final String DATETIME_PATTERN = "yyyy.MM.dd.HH.mm.ss";
	
	/** ��¥ ��ȯ�� */
	private static final DateTimeFormatter DATETIME_FORMATTER = 
			DateTimeFormatter.ofPattern(DATETIME_PATTERN);

	/**
     * �־��� ��¥�� String Ÿ������ ��ȯ�Ѵ�. ������ ������
     * {@link DateUtil#DATETIME_PATTERN}�� ���ȴ�.
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
     * String�� {@link DateUtil#DATETIME_PATTERN}�� ������ ���
     * {@link LocalDate} ��ü�� ��ȯ�Ѵ�.
     *
     * String�� ��ȯ���� ������ null�� ��ȯ�Ѵ�.
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
     * ��ȿ�� ��¥���� �˻��Ѵ�.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
	public static boolean validDate(String dateString) {
    	// Try to parse the String.
    	return DateUtil.parse(dateString) != null;
    }
}
