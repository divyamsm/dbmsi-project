/*  File MID.java   */

package global;

import java.io.*;

/** class MID
 */

public class MID implements Serializable{
  
  /** public int slotNo
   */
  public int slotNo;
  
  /** public PageId pageNo
   */
  public PageId pageNo = new PageId();
  
  /**
   * default constructor of class
   */
  public MID () { }
  
  /**
   *  constructor of class
   */
  public MID (PageId pageno, int slotno)
    {
      pageNo = pageno;
      slotNo = slotno;
    }
  
  /**
   * make a copy of the given rid
   */
  public void copyMid (MID mid)
    {
      pageNo = mid.pageNo;
      slotNo = mid.slotNo;
    }
  
  /** Write the rid into a byte array at offset
   * @param ary the specified byte array
   * @param offset the offset of byte array to write 
   * @exception java.io.IOException I/O errors
   */ 
  public void writeToByteArray(byte [] ary, int offset)
    throws java.io.IOException
    {
      Convert.setIntValue ( slotNo, offset, ary);
      Convert.setIntValue ( pageNo.pid, offset+4, ary);
    }
  
  
  /** Compares two MID object, i.e, this to the mid
   * @param mid MID object to be compared to
   * @return true is they are equal
   *         false if not.
   */
  public boolean equals(MID mid) {
    
    if ((this.pageNo.pid==mid.pageNo.pid)
	&&(this.slotNo==mid.slotNo))
      return true;
    else
      return false;
  }
  
  public RID midToRid(MID mid){
    return new RID(mid.pageNo,mid.slotNo);
  }
  
  public MID ridToMid(RID rid){
	    return new MID(rid.pageNo,rid.slotNo);
	  }
}
