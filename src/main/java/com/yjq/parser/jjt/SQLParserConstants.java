/* Generated By:JJTree&JavaCC: Do not edit this line. SQLParserConstants.java */
package com.yjq.parser.jjt;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface SQLParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int CREATE = 5;
  /** RegularExpression Id. */
  int TABLE = 6;
  /** RegularExpression Id. */
  int DROP = 7;
  /** RegularExpression Id. */
  int DELETE = 8;
  /** RegularExpression Id. */
  int UPDATE = 9;
  /** RegularExpression Id. */
  int SELECT = 10;
  /** RegularExpression Id. */
  int INSERT = 11;
  /** RegularExpression Id. */
  int WHERE = 12;
  /** RegularExpression Id. */
  int SET = 13;
  /** RegularExpression Id. */
  int FROM = 14;
  /** RegularExpression Id. */
  int INTO = 15;
  /** RegularExpression Id. */
  int DISTINCT = 16;
  /** RegularExpression Id. */
  int ALL = 17;
  /** RegularExpression Id. */
  int LIKE = 18;
  /** RegularExpression Id. */
  int ORDER = 19;
  /** RegularExpression Id. */
  int BY = 20;
  /** RegularExpression Id. */
  int AS = 21;
  /** RegularExpression Id. */
  int VALUES = 22;
  /** RegularExpression Id. */
  int AND = 23;
  /** RegularExpression Id. */
  int IN = 24;
  /** RegularExpression Id. */
  int INT = 25;
  /** RegularExpression Id. */
  int CHAR = 26;
  /** RegularExpression Id. */
  int DATE = 27;
  /** RegularExpression Id. */
  int DOUBLE = 28;
  /** RegularExpression Id. */
  int IS = 29;
  /** RegularExpression Id. */
  int NOT = 30;
  /** RegularExpression Id. */
  int ISNULL = 31;
  /** RegularExpression Id. */
  int NOTNULL = 32;
  /** RegularExpression Id. */
  int NULL = 33;
  /** RegularExpression Id. */
  int OR = 34;
  /** RegularExpression Id. */
  int BETWEEN = 35;
  /** RegularExpression Id. */
  int GROUP = 36;
  /** RegularExpression Id. */
  int HAVING = 37;
  /** RegularExpression Id. */
  int LIMIT = 38;
  /** RegularExpression Id. */
  int OFFSET = 39;
  /** RegularExpression Id. */
  int ASC = 40;
  /** RegularExpression Id. */
  int DESC = 41;
  /** RegularExpression Id. */
  int LAST = 42;
  /** RegularExpression Id. */
  int FIRST = 43;
  /** RegularExpression Id. */
  int NULLS = 44;
  /** RegularExpression Id. */
  int EXISTS = 45;
  /** RegularExpression Id. */
  int REFERENCES = 46;
  /** RegularExpression Id. */
  int FOREIGN = 47;
  /** RegularExpression Id. */
  int PRIMARY = 48;
  /** RegularExpression Id. */
  int KEY = 49;
  /** RegularExpression Id. */
  int UNIQUE = 50;
  /** RegularExpression Id. */
  int UNDERSCORE = 51;
  /** RegularExpression Id. */
  int COMMA = 52;
  /** RegularExpression Id. */
  int SEMICOLON = 53;
  /** RegularExpression Id. */
  int COLON = 54;
  /** RegularExpression Id. */
  int LEFTPARENTHESES = 55;
  /** RegularExpression Id. */
  int RIGHTPARENTHESES = 56;
  /** RegularExpression Id. */
  int EQUAL = 57;
  /** RegularExpression Id. */
  int PLUS = 58;
  /** RegularExpression Id. */
  int MINUS = 59;
  /** RegularExpression Id. */
  int TIMES = 60;
  /** RegularExpression Id. */
  int DIVIDE = 61;
  /** RegularExpression Id. */
  int DOT = 62;
  /** RegularExpression Id. */
  int GREATERTHAN = 63;
  /** RegularExpression Id. */
  int GREATERTHANOREQUALTO = 64;
  /** RegularExpression Id. */
  int LESSTHAN = 65;
  /** RegularExpression Id. */
  int LESSTHANOREQUALTO = 66;
  /** RegularExpression Id. */
  int LEFTQUOTATION = 67;
  /** RegularExpression Id. */
  int NOTEUQAL = 68;
  /** RegularExpression Id. */
  int NOTEQUAL = 69;
  /** RegularExpression Id. */
  int NOTGREATER = 70;
  /** RegularExpression Id. */
  int NOTLESS = 71;
  /** RegularExpression Id. */
  int LQUOTATION = 72;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 73;
  /** RegularExpression Id. */
  int FLOAT_LITERAL = 74;
  /** RegularExpression Id. */
  int DIGIT = 75;
  /** RegularExpression Id. */
  int IDENTIFIER = 76;
  /** RegularExpression Id. */
  int LETTER = 77;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\r\\n\"",
    "\"create\"",
    "\"table\"",
    "\"drop\"",
    "\"delete\"",
    "\"update\"",
    "\"select\"",
    "\"insert\"",
    "\"where\"",
    "\"set\"",
    "\"from\"",
    "\"into\"",
    "\"distinct\"",
    "\"all\"",
    "\"like\"",
    "\"order\"",
    "\"by\"",
    "\"as\"",
    "\"values\"",
    "\"and\"",
    "\"in\"",
    "\"int\"",
    "\"char\"",
    "\"date\"",
    "\"double\"",
    "\"is\"",
    "\"not\"",
    "\"ISNULL\"",
    "\"NOTNULL\"",
    "\"null\"",
    "\"or\"",
    "\"between\"",
    "\"group\"",
    "\"having\"",
    "\"limit\"",
    "\"offset\"",
    "\"asc\"",
    "\"desc\"",
    "\"last\"",
    "\"first\"",
    "\"nulls\"",
    "\"exists\"",
    "\"references\"",
    "\"foreign\"",
    "\"primary\"",
    "\"key\"",
    "\"unique\"",
    "\"_\"",
    "\",\"",
    "\";\"",
    "\":\"",
    "\"(\"",
    "\")\"",
    "\"=\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\".\"",
    "\">\"",
    "\">=\"",
    "\"<\"",
    "\"<=\"",
    "\"\\\"\"",
    "\"!=\"",
    "\"<>\"",
    "\"!>\"",
    "\"!<\"",
    "\"\\\'\"",
    "<INTEGER_LITERAL>",
    "<FLOAT_LITERAL>",
    "<DIGIT>",
    "<IDENTIFIER>",
    "<LETTER>",
  };

}
