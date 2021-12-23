/* SQLParserTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. SQLParserTokenManager.java */
package com.yjq.parser.jjt;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.yjq.parser.jjt.*;
import com.yjq.parser.operator.*;
import com.yjq.parser.server.*;

/** Token Manager. */
@SuppressWarnings ("unused")
public class SQLParserTokenManager implements SQLParserConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7ffffffffffe0L) != 0L)
         {
            jjmatchedKind = 76;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x10423388800L) != 0L)
            return 9;
         if ((active0 & 0x7fefbdcc777e0L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 76;
               jjmatchedPos = 1;
            }
            return 9;
         }
         return -1;
      case 2:
         if ((active0 & 0x201004282a000L) != 0L)
            return 9;
         if ((active0 & 0x5fefb9c4d5fe0L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 76;
               jjmatchedPos = 2;
            }
            return 9;
         }
         return -1;
      case 3:
         if ((active0 & 0x5e8f990491f60L) != 0L)
         {
            if (jjmatchedPos != 3)
            {
               jjmatchedKind = 76;
               jjmatchedPos = 3;
            }
            return 9;
         }
         if ((active0 & 0x16020c04c080L) != 0L)
            return 9;
         return -1;
      case 4:
         if ((active0 & 0x185000081040L) != 0L)
            return 9;
         if ((active0 & 0x5e0a990410f20L) != 0L)
         {
            jjmatchedKind = 76;
            jjmatchedPos = 4;
            return 9;
         }
         return -1;
      case 5:
         if ((active0 & 0x1c00900010000L) != 0L)
         {
            jjmatchedKind = 76;
            jjmatchedPos = 5;
            return 9;
         }
         if ((active0 & 0x420a090400f20L) != 0L)
            return 9;
         return -1;
      case 6:
         if ((active0 & 0x1800900000000L) != 0L)
            return 9;
         if ((active0 & 0x400000010000L) != 0L)
         {
            jjmatchedKind = 76;
            jjmatchedPos = 6;
            return 9;
         }
         return -1;
      case 7:
         if ((active0 & 0x400000000000L) != 0L)
         {
            jjmatchedKind = 76;
            jjmatchedPos = 7;
            return 9;
         }
         if ((active0 & 0x10000L) != 0L)
            return 9;
         return -1;
      case 8:
         if ((active0 & 0x400000000000L) != 0L)
         {
            jjmatchedKind = 76;
            jjmatchedPos = 8;
            return 9;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 3;
         return jjMoveStringLiteralDfa1_0(0x10L, 0x0L);
      case 33:
         return jjMoveStringLiteralDfa1_0(0x0L, 0xd0L);
      case 34:
         return jjStopAtPos(0, 67);
      case 39:
         return jjStopAtPos(0, 72);
      case 40:
         return jjStopAtPos(0, 55);
      case 41:
         return jjStopAtPos(0, 56);
      case 42:
         return jjStopAtPos(0, 60);
      case 43:
         return jjStopAtPos(0, 58);
      case 44:
         return jjStopAtPos(0, 52);
      case 45:
         return jjStopAtPos(0, 59);
      case 46:
         return jjStopAtPos(0, 62);
      case 47:
         return jjStopAtPos(0, 61);
      case 58:
         return jjStopAtPos(0, 54);
      case 59:
         return jjStopAtPos(0, 53);
      case 60:
         jjmatchedKind = 65;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x24L);
      case 61:
         return jjStopAtPos(0, 57);
      case 62:
         jjmatchedKind = 63;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x80000000L, 0x0L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x100000000L, 0x0L);
      case 95:
         return jjStopAtPos(0, 51);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x10000a20000L, 0x0L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x800100000L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x4000020L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x20018010180L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x200000000000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x880000004000L, 0x0L);
      case 103:
         return jjMoveStringLiteralDfa1_0(0x1000000000L, 0x0L);
      case 104:
         return jjMoveStringLiteralDfa1_0(0x2000000000L, 0x0L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x23008800L, 0x0L);
      case 107:
         return jjMoveStringLiteralDfa1_0(0x2000000000000L, 0x0L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x44000040000L, 0x0L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x100240000000L, 0x0L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x8400080000L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x1000000000000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x400000000000L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x2400L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x40L, 0x0L);
      case 117:
         return jjMoveStringLiteralDfa1_0(0x4000000000200L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x400000L, 0x0L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x1000L, 0x0L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0, long active1){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x10L) != 0L)
            return jjStopAtPos(1, 4);
         break;
      case 60:
         if ((active1 & 0x80L) != 0L)
            return jjStopAtPos(1, 71);
         break;
      case 61:
         if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(1, 64);
         else if ((active1 & 0x4L) != 0L)
            return jjStopAtPos(1, 66);
         else if ((active1 & 0x10L) != 0L)
            return jjStopAtPos(1, 68);
         break;
      case 62:
         if ((active1 & 0x20L) != 0L)
            return jjStopAtPos(1, 69);
         else if ((active1 & 0x40L) != 0L)
            return jjStopAtPos(1, 70);
         break;
      case 79:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L, active1, 0L);
      case 83:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L, active1, 0L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x42008400040L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x2420800002500L, active1, 0L);
      case 102:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000L, active1, 0L);
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x4001000L, active1, 0L);
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x84000050000L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000L, active1, 0L);
      case 110:
         if ((active0 & 0x1000000L) != 0L)
         {
            jjmatchedKind = 24;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x4000002808800L, active1, 0L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x800050000000L, active1, 0L);
      case 112:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L, active1, 0L);
      case 114:
         if ((active0 & 0x400000000L) != 0L)
         {
            jjmatchedKind = 34;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x10010000840a0L, active1, 0L);
      case 115:
         if ((active0 & 0x200000L) != 0L)
         {
            jjmatchedKind = 21;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(1, 29, 9);
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x100200000000L, active1, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000000000L, active1, 0L);
      case 121:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(1, 20, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1){
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 78:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      case 84:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 99:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 40, 9);
         break;
      case 100:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(2, 23, 9);
         return jjMoveStringLiteralDfa3_0(active0, 0x80200L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1020L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x408000000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x5200000000000L);
      case 107:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      case 108:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(2, 17, 9);
         return jjMoveStringLiteralDfa3_0(active0, 0x100200400500L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000004080L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x880000000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x60000010800L);
      case 116:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(2, 13, 9);
         else if ((active0 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 25;
            jjmatchedPos = 2;
         }
         else if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(2, 30, 9);
         return jjMoveStringLiteralDfa3_0(active0, 0x808008000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000L);
      case 118:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000L);
      case 121:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 49, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 78:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000L);
      case 85:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x220L);
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 99:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 41, 9);
         break;
      case 101:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 18, 9);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(3, 27, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0xc00000080d00L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x6000000000L);
      case 108:
         if ((active0 & 0x200000000L) != 0L)
         {
            jjmatchedKind = 33;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000040L);
      case 109:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000000L);
      case 111:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(3, 15, 9);
         break;
      case 112:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(3, 7, 9);
         break;
      case 113:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000000L);
      case 114:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(3, 26, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x1000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x288000000000L);
      case 116:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 42, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000400000L);
      case 119:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 76:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 85:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000000L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      case 101:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(4, 6, 9);
         else if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(4, 12, 9);
         return jjMoveStringLiteralDfa5_0(active0, 0x8800400000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000010000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000000L);
      case 112:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 36, 9);
         break;
      case 114:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 19, 9);
         return jjMoveStringLiteralDfa5_0(active0, 0x400000000800L);
      case 115:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 44, 9);
         break;
      case 116:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 38, 9);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 43, 9);
         return jjMoveStringLiteralDfa5_0(active0, 0x200000000320L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 76:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(5, 31, 9);
         return jjMoveStringLiteralDfa6_0(active0, 0x100000000L);
      case 101:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(5, 5, 9);
         else if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(5, 8, 9);
         else if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(5, 9, 9);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 28, 9);
         else if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 50, 9);
         return jjMoveStringLiteralDfa6_0(active0, 0x400800000000L);
      case 103:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 37, 9);
         return jjMoveStringLiteralDfa6_0(active0, 0x800000000000L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000L);
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000000000000L);
      case 115:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(5, 22, 9);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 45, 9);
         break;
      case 116:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(5, 10, 9);
         else if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(5, 11, 9);
         else if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 39, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 76:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(6, 32, 9);
         break;
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000L);
      case 110:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(6, 35, 9);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 47, 9);
         return jjMoveStringLiteralDfa7_0(active0, 0x400000000000L);
      case 121:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 48, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0x400000000000L);
      case 116:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(7, 16, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa9_0(active0, 0x400000000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 115:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 46, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0, 0L);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 9;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 9:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 76)
                        kind = 76;
                     { jjCheckNAdd(3); }
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(2, 3); }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 76)
                        kind = 76;
                     { jjCheckNAdd(3); }
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(2, 3); }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 76)
                        kind = 76;
                  }
                  break;
               case 0:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 73)
                     kind = 73;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(2, 3); }
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 76)
                     kind = 76;
                  { jjCheckNAdd(3); }
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 73)
                     kind = 73;
                  { jjCheckNAdd(5); }
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(6, 7); }
                  break;
               case 7:
                  if (curChar != 46)
                     break;
                  kind = 74;
                  { jjCheckNAdd(8); }
                  break;
               case 8:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 74)
                     kind = 74;
                  { jjCheckNAdd(8); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 9:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     { jjCheckNAddTwoStates(2, 3); }
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 76)
                        kind = 76;
                     { jjCheckNAdd(3); }
                  }
                  break;
               case 1:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     { jjCheckNAddTwoStates(2, 3); }
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 76)
                        kind = 76;
                     { jjCheckNAdd(3); }
                  }
                  break;
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 76)
                     kind = 76;
                  { jjCheckNAddStates(3, 5); }
                  break;
               case 2:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     { jjCheckNAddTwoStates(2, 3); }
                  break;
               case 3:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 76)
                     kind = 76;
                  { jjCheckNAdd(3); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 9 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, "\143\162\145\141\164\145", 
"\164\141\142\154\145", "\144\162\157\160", "\144\145\154\145\164\145", "\165\160\144\141\164\145", 
"\163\145\154\145\143\164", "\151\156\163\145\162\164", "\167\150\145\162\145", "\163\145\164", 
"\146\162\157\155", "\151\156\164\157", "\144\151\163\164\151\156\143\164", "\141\154\154", 
"\154\151\153\145", "\157\162\144\145\162", "\142\171", "\141\163", "\166\141\154\165\145\163", 
"\141\156\144", "\151\156", "\151\156\164", "\143\150\141\162", "\144\141\164\145", 
"\144\157\165\142\154\145", "\151\163", "\156\157\164", "\111\123\116\125\114\114", 
"\116\117\124\116\125\114\114", "\156\165\154\154", "\157\162", "\142\145\164\167\145\145\156", 
"\147\162\157\165\160", "\150\141\166\151\156\147", "\154\151\155\151\164", 
"\157\146\146\163\145\164", "\141\163\143", "\144\145\163\143", "\154\141\163\164", 
"\146\151\162\163\164", "\156\165\154\154\163", "\145\170\151\163\164\163", 
"\162\145\146\145\162\145\156\143\145\163", "\146\157\162\145\151\147\156", "\160\162\151\155\141\162\171", 
"\153\145\171", "\165\156\151\161\165\145", "\137", "\54", "\73", "\72", "\50", "\51", "\75", 
"\53", "\55", "\52", "\57", "\56", "\76", "\76\75", "\74", "\74\75", "\42", "\41\75", 
"\74\76", "\41\76", "\41\74", "\47", null, null, null, null, null, };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   5, 6, 7, 1, 2, 3, 
};

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100000400L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public SQLParserTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public SQLParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 9; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffffffffe1L, 0x17ffL, 
};
static final long[] jjtoSkip = {
   0x1eL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x0L, 0x0L, 
};
static final long[] jjtoMore = {
   0x0L, 0x0L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[9];
    private final int[] jjstateSet = new int[2 * 9];
    private final StringBuilder jjimage = new StringBuilder();
    private StringBuilder image = jjimage;
    private int jjimageLen;
    private int lengthOfMatch;
    protected int curChar;
}
