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
  int CREATE = 6;
  /** RegularExpression Id. */
  int TABLE = 7;
  /** RegularExpression Id. */
  int DROP = 8;
  /** RegularExpression Id. */
  int DELETE = 9;
  /** RegularExpression Id. */
  int UPDATE = 10;
  /** RegularExpression Id. */
  int SELECT = 11;
  /** RegularExpression Id. */
  int INSERT = 12;
  /** RegularExpression Id. */
  int WHERE = 13;
  /** RegularExpression Id. */
  int SET = 14;
  /** RegularExpression Id. */
  int FROM = 15;
  /** RegularExpression Id. */
  int INTO = 16;
  /** RegularExpression Id. */
  int DISTINCT = 17;
  /** RegularExpression Id. */
  int ALL = 18;
  /** RegularExpression Id. */
  int LIKE = 19;
  /** RegularExpression Id. */
  int ORDER = 20;
  /** RegularExpression Id. */
  int BY = 21;
  /** RegularExpression Id. */
  int AS = 22;
  /** RegularExpression Id. */
  int VALUES = 23;
  /** RegularExpression Id. */
  int AND = 24;
  /** RegularExpression Id. */
  int IN = 25;
  /** RegularExpression Id. */
  int INT = 26;
  /** RegularExpression Id. */
  int CHAR = 27;
  /** RegularExpression Id. */
  int DATE = 28;
  /** RegularExpression Id. */
  int DOUBLE = 29;
  /** RegularExpression Id. */
  int IS = 30;
  /** RegularExpression Id. */
  int NOT = 31;
  /** RegularExpression Id. */
  int ISNULL = 32;
  /** RegularExpression Id. */
  int NOTNULL = 33;
  /** RegularExpression Id. */
  int NULL = 34;
  /** RegularExpression Id. */
  int OR = 35;
  /** RegularExpression Id. */
  int BETWEEN = 36;
  /** RegularExpression Id. */
  int GROUP = 37;
  /** RegularExpression Id. */
  int HAVING = 38;
  /** RegularExpression Id. */
  int LIMIT = 39;
  /** RegularExpression Id. */
  int OFFSET = 40;
  /** RegularExpression Id. */
  int ASC = 41;
  /** RegularExpression Id. */
  int DESC = 42;
  /** RegularExpression Id. */
  int LAST = 43;
  /** RegularExpression Id. */
  int FIRST = 44;
  /** RegularExpression Id. */
  int NULLS = 45;
  /** RegularExpression Id. */
  int EXISTS = 46;
  /** RegularExpression Id. */
  int REFERENCES = 47;
  /** RegularExpression Id. */
  int FOREIGN = 48;
  /** RegularExpression Id. */
  int PRIMARY = 49;
  /** RegularExpression Id. */
  int KEY = 50;
  /** RegularExpression Id. */
  int UNIQUE = 51;
  /** RegularExpression Id. */
  int UNDERSCORE = 52;
  /** RegularExpression Id. */
  int COMMA = 53;
  /** RegularExpression Id. */
  int SEMICOLON = 54;
  /** RegularExpression Id. */
  int COLON = 55;
  /** RegularExpression Id. */
  int LEFTPARENTHESES = 56;
  /** RegularExpression Id. */
  int RIGHTPARENTHESES = 57;
  /** RegularExpression Id. */
  int EQUAL = 58;
  /** RegularExpression Id. */
  int PLUS = 59;
  /** RegularExpression Id. */
  int MINUS = 60;
  /** RegularExpression Id. */
  int TIMES = 61;
  /** RegularExpression Id. */
  int DIVIDE = 62;
  /** RegularExpression Id. */
  int DOT = 63;
  /** RegularExpression Id. */
  int GREATERTHAN = 64;
  /** RegularExpression Id. */
  int GREATERTHANOREQUALTO = 65;
  /** RegularExpression Id. */
  int LESSTHAN = 66;
  /** RegularExpression Id. */
  int LESSTHANOREQUALTO = 67;
  /** RegularExpression Id. */
  int LEFTQUOTATION = 68;
  /** RegularExpression Id. */
  int NOTEUQAL = 69;
  /** RegularExpression Id. */
  int NOTEQUAL = 70;
  /** RegularExpression Id. */
  int NOTGREATER = 71;
  /** RegularExpression Id. */
  int NOTLESS = 72;
  /** RegularExpression Id. */
  int LQUOTATION = 73;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 74;
  /** RegularExpression Id. */
  int FLOAT_LITERAL = 75;
  /** RegularExpression Id. */
  int SYMBOL = 76;
  /** RegularExpression Id. */
  int DIGIT = 77;
  /** RegularExpression Id. */
  int IDENTIFIER = 78;
  /** RegularExpression Id. */
  int LETTER = 79;
  /** RegularExpression Id. */
  int CHARC = 80;
  /** RegularExpression Id. */
  int STRING = 81;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
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
    "\"isnull\"",
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
    "<SYMBOL>",
    "<DIGIT>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<CHARC>",
    "<STRING>",
  };

}
