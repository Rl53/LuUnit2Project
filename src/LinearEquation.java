public class LinearEquation {
        /* Instance Variables */
        private int x1;
        private int y1;
        private int x2;
        private int y2;


        /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated) */

public LinearEquation(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
}

/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
        public double distance() {
            return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        }


        /* Calculates and returns the y-intercept of the line between (x1, y1) and
           (x2, y2), rounded to the nearest hundredth */
        public double yIntercept() {
            return roundedToHundredth(y1 - ((double)(y2 - y1) / (x2 - x1)) * (x1));
        }


        /* Calculates and returns the slope of the line between (x1, y1) and
           (x2, y2), rounded to the nearest hundredth */
        public double slope() {
            return roundedToHundredth((double)(y2 - y1) / (x2 - x1));
        }


        /* Returns a String that represents the linear equation of the line through points
           (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

            When generating the m value (slope), here are examples of "printable" slopes:
               5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

            Here are non-examples of "printable" slopes:
         1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
               -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

            HINT: Be sure to check if the line is horizontal and return an appropriate string,
            e.g. y = 6
            HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


            When generating the b value, here are some examples of "printable" y-intercepts:
               + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

            Here are non-examples of "printable" y-intercepts:
               - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

            HINT: Absolute value might be helpful for printing negative y-intercepts as
                   subtraction!
         */
        public String equation() {
            // assigning the numerator of the slope as slopeY and the denominator as slopeX
            int slopeY = y2 - y1;
            int slopeX = x2 - x1;
            String fraction = "";

            // assigns the string 'fraction' as a positive or negative slope
            if(slopeY % slopeX != 0) {
                if ((slopeX > 0 && slopeY > 0) || (slopeX < 0 && slopeY < 0)) {
                    fraction = Math.abs(slopeY) + "/" + Math.abs(slopeX);
                }
                else {
                    if(slopeX < 0 || slopeY < 0) {
                            fraction = "-" + Math.abs(slopeY) + "/" + Math.abs(slopeX);
                    }
                }
            }
            /* assigns the string 'fraction' to only include the sign of the slope if the slope
            is equal to 1 or -1 */
            else {
                fraction = "" + (int)slope();
                if (slope() == 1 || slope() == 0) {
                    fraction = "";
                }
                if (slope() == -1) {
                    fraction = "-";
                }
            }

            // initialized the strings representing the y-intercept and x
            String posOrNegIntercept;
            String xExist = "x";
            String newYIntercept = "" + yIntercept();

            // turns the y-intercept into an integer if it is a whole number
            if (Math.abs((int) yIntercept()) == Math.abs(yIntercept())) {
                newYIntercept = "" + (Math.abs((int) yIntercept()));
            }

            // if the slope is 0, then x is set to an empty string because it does not have a value
            if (slope() == 0) {
                xExist = "";
            }

            if (yIntercept() > 0) {
                // checks if the line is horizontal and returns the appropriate string
                if (xExist.equals("")) {
                    posOrNegIntercept = "" + newYIntercept;
                }
                // combines the slope times x with the y-intercept into a string
                else {
                    posOrNegIntercept = xExist + " + " + newYIntercept;
                }
            }
            /* if the y-intercept is 0, then the string will either remove it or add it by itself
            depending on whether x exists */
            else {
                if(yIntercept() == 0) {
                    // checks for horizontal line
                    if (xExist.equals("")) {
                        posOrNegIntercept = "" + newYIntercept;
                    }
                    else {
                        posOrNegIntercept = xExist;
                    }
                }
                else {
                    // checks for horizontal line
                    if (xExist.equals("")) {
                        posOrNegIntercept = "-" + newYIntercept;
                    }
                    else {
                        posOrNegIntercept = xExist + " - " + newYIntercept;
                    }
                }
            }
            // returns the combined equation
            return "y = " + fraction + posOrNegIntercept;
        }


        /* Returns a String of the coordinate point on the line that has the given x value, with
           both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
        public String coordinateForX(double xValue) {
            double yValue = roundedToHundredth(xValue * slope() + yIntercept());
            xValue = roundedToHundredth(xValue);
            return "The point on the line is (" + xValue + ", " + yValue + ")";
        }


        /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
            to the nearest hundredth

            HINT:  the Math.round method can help with this!
         */
        public double roundedToHundredth(double toRound) {
            return ((double) Math.round(toRound * 100) / 100);
        }


        /* Returns a string that includes all information about the linear equation, each on
           separate lines:
             - The original points: (x1, y1) and (x2, y2)
             - The equation of the line in y = mx + b format (using equation() method)
             - The slope of the line, as a decimal (using slope() method)
             - The y-intercept of the line (using yIntercept() method)
             - The distance between the two points (using distance() method)

          This method should call all other appropriate methods to get the info it needs:
          equation(), slope(), yIntercept(), distance().

          */
        public String lineInfo() {
            return "\n----Line Info----\nThe original points: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 +
                    ")\nThe equation of the line is " + equation() + "\nThe slope of this line is: " + slope() +
                    "\nThe y-intercept of the line is: " + yIntercept() + "\nThe distance between the two points is: " +
                    distance() + "\n";

        }

}