package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House 
       extends Building {

       // TODO - Put your code here.
       private boolean mPool;
       private String mOwner;

       // Constructors
       House(int length, int width, int lotLength, int lotWidth) {
              super(length, width, lotLength, lotWidth);
       }

       House(int length, int width, int lotLength, int lotWidth, String owner) {
              super(length, width, lotLength, lotWidth);
              mOwner = owner;
       }

       House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
              super(length, width, lotLength, lotWidth);
              mOwner = owner;
              mPool = pool;
       }

       public void setPool(boolean hasPool) {
              this.mPool = hasPool;
       }

       // This redundancy is to work around broken unit test
       public void setmPool(boolean hasPool) {
              this.setPool(hasPool);
       }

       public boolean hasPool() {
              return this.mPool;
       }


       public String getOwner() {
              return mOwner;
       }

       public void setmOwner(String mOwner) {
              this.mOwner = mOwner;
       }

       public boolean hasBigOpenSpace() {
              if (calcLotArea() > calcBuildingArea()) {
                     return true;
              }
              return false;
       }

       /**
        * Details about this house.
        *
        * @return string representation of house
        */
       public String toString(){
              String message = "Owner: ";
              if (mOwner == null) {
                     message += "n/a";
              } else {
                     message += mOwner;
              }

              if (mPool) {
                     message += "; has a pool";
              }

              if (hasBigOpenSpace()) {
                     message += "; has a big open space";
              }
              return message;
       }

       /**
        * Two buildings are equal if their building areas
        * are equal and their pool status is the same.
        *
        * @param house
        * @return true if criteria are met
        */
       public boolean equals(House house) {
              if (house.hasPool() == hasPool() && house.calcBuildingArea() == calcBuildingArea()) {
                     return true;

              }
              return false;
       }
}
