package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {

       private String mBusinessName;
       private int mParkingSpaces = 0;
       private static int sTotalOffices = 0;

       // constructors
       Office(int length, int width, int lotLength, int lotWidth) {
              super(length, width, lotLength, lotWidth);
              sTotalOffices++;
       }

       Office(int length, int width, int lotLength, int lotWidth, String businessName) {
              this(length, width, lotLength, lotWidth);
              this.mBusinessName = businessName;
       }

       Office(int length, int width, int lotLength, int lotWidth, String businessName,
              int parkingSpaces) {
              this(length, width, lotLength, lotWidth);
              this.mBusinessName = businessName;
              this.mParkingSpaces = parkingSpaces;
       }

       public String getmBusinessName() {
              return mBusinessName;
       }

       public void setmBusinessName(String mBusinessName) {
              this.mBusinessName = mBusinessName;
       }

       public int getmParkingSpaces() {
              return mParkingSpaces;
       }

       public int getParkingSpaces() {
              return getmParkingSpaces();
       }

       public void setmParkingSpaces(int parkingSpaces) {
              this.mParkingSpaces = parkingSpaces;
       }

       public String toString(){
              String message = "Business: ";

              if (mBusinessName == null) {
                     message += "unoccupied";
              } else {
                     message += mBusinessName;
              }

              if (mParkingSpaces > 0) {
                     message += "; has " + mParkingSpaces + " parking spaces";
              }

              message += " (total offices: " + sTotalOffices + ")";

              return message;
       }

       /**
        * Two office buildings are equal if their building
        * area and number of parking spaces is equal.
        *
        * @param building the object being compared
        * @return true if criteria are met
        */
       public boolean equals(Building building) {
              if (building.calcBuildingArea() == calcBuildingArea() &&
                      building.getParkingSpaces() == getmParkingSpaces()) {
                     return true;
              }
              return false;
       }

}
