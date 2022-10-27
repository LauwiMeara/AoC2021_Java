package decoder;

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
	 * @param rateType	The rate type you want to decode, EPSILON or GAMMA.
	 * @return			The rate, consisting of all least common (EPSILON) or most common (GAMMA) bits, represented in decimal value.
	 */
	private int getRate(RateType rateType) {
		String rate = "";

		// Check each position
		for (int pos = 0; pos < data.get(0).length(); pos++) {
			
			// Count all zeros and ones
			int zeros = 0;
			int ones = 0;
			for (String line : data) {
				if (line.charAt(pos) == '0') {
					zeros++;
				} else if (line.charAt(pos) == '1') {
					ones++;
				}
			}
			
			// Epsilon rate consists of least common bits.
			if (rateType == RateType.EPSILON) {
				if (zeros < ones) {
					rate += '0';
				} else {
					rate += '1';
				}
			}
			// Gamma rate consists of most common bits
			else if (rateType == RateType.GAMMA) {
				if (zeros > ones) {
					rate += '0';
				} else {
					rate += '1';
				}
			}
		}
		return Integer.parseInt(rate, 2);
	}
	
	/**
	 * Get power consumption by multiplying the gamma and epsilon rates.
	 * @return	The power consumption.
	 */
	public int getPowerConsumption() {
		int gammaRate = getRate(RateType.GAMMA);
		int epsilonRate = getRate(RateType.EPSILON);
		return gammaRate * epsilonRate;
	}
}
