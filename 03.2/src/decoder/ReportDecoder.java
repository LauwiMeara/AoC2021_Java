package decoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to decode the diagnostic report.
 * @author Laura Luijben
 *
 */
public class ReportDecoder {
	private List<String> data;
	
	public ReportDecoder(List<String> data) {
		this.data = data;
	}

	/**
	 * Provides the rate for the given rate type.
	 * @param rateType	The rate type you want to decode, OXYGEN or CO2.
	 * @return			The rate, consisting of one line that only had the most common (OXYGEN) or least common (CO2) bits, represented in decimal value.
	 */
	private int getRate(RateType rateType) {
		
		// Copy ArrayList
		ArrayList<String> dataCopy = new ArrayList<>();
		for (String line : data) {
			dataCopy.add(line);
		}
		
		// Check each position
		for (int pos = 0; pos < dataCopy.get(0).length(); pos++) {
			// Break out of the for-loop if only one rate remains
			if (dataCopy.size() == 1) {
				break;
			}
			
			// Count all zeros and ones
			int zeros = 0;
			int ones = 0;
			for (String line : dataCopy) {
				if (line.charAt(pos) == '0') {
					zeros++;
				} else if (line.charAt(pos) == '1') {
					ones++;
				}
			}
			
			// Determine most common bit. If bits are equally common, count 1 as common bit
			char commonBit = zeros > ones ? '0' : '1';
			
			// Remove the required bits from the copied data
			for (int line = dataCopy.size() - 1; line >= 0; line--) {
				if (rateType == RateType.OXYGEN && dataCopy.get(line).charAt(pos) != commonBit) {
					// Oxygen rate is determined by only keeping the values with the most common bits
					dataCopy.remove(line);
				} else if (rateType == RateType.CO2 && dataCopy.get(line).charAt(pos) == commonBit) {
					// CO2 rate is determined by only keeping the values with the least common bits
					dataCopy.remove(line);
				}
			}
		}
		return Integer.parseInt(dataCopy.get(0), 2);
	}
	
	/**
	 * Get life rating by multiplying the oxygen and co2 rates.
	 * @return	The life rating.
	 */
	public int getLifeRate() {
		int oxygenRate = getRate(RateType.OXYGEN);
		int co2Rate = getRate(RateType.CO2);
		return oxygenRate * co2Rate;
	}
}
