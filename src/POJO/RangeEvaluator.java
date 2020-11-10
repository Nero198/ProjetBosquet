package POJO;

import java.awt.Color;
import java.util.Date;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;

public class RangeEvaluator implements IDateEvaluator {
	    private DateUtil dateUtil = new DateUtil();

		@Override
		public Color getInvalidBackroundColor() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Color getInvalidForegroundColor() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getInvalidTooltip() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Color getSpecialBackroundColor() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Color getSpecialForegroundColor() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getSpecialTooltip() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isInvalid(Date date) {
			// TODO Auto-generated method stub
			return dateUtil.checkDate(date);
		}

		@Override
		public boolean isSpecial(Date arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		public void setStartDate(Date startDate) {
	        dateUtil.setMinSelectableDate(startDate);
	    }
	    /**
	     * @return the initial date in the range to be validated.
	     */
	    public Date getStartDate() {
	        return dateUtil.getMinSelectableDate();
	    }
	    /**
	     * Sets the final date in the range to be validated.
	     * @param endDate 
	     */
	    public void setEndDate(Date endDate) {
	        dateUtil.setMaxSelectableDate(endDate);
	    }
	    /**
	     * @return the final date in the range to be validated.
	     */
	    public Date getEndDate() {
	        return dateUtil.getMaxSelectableDate();
	    }  
	    
	}
