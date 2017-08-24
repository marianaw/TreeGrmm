import scala.collection.mutable.ArrayBuffer

/**
  * Created by mariana on 8/23/17.
  */

object FeatureExtractor {

  // Regular expressions for feature extraction:
  val Capitalized = "^[A-Z].*".r
  val Numeric = "^[0-9]+$".r
  val Punctuation = "[-,\\.;:?!()]+".r

  def wordToFeatures(word:String, initialFeatures:String*) : Seq[String] = {
    val buf = new ArrayBuffer[String]
    buf += "WORD="+word
    buf ++= initialFeatures
    if(word.length > 3){
      buf += "HEAD="+word.substring(0,3)
    }
    if(word.length > 5){
      buf += "TAIL="+word.substring(word.length - 3, word.length)
    }
    if(Capitalized.findFirstMatchIn(word) != None) buf += "IS_TITLE"
    if(Numeric.findFirstMatchIn(word) != None) buf += "NUMERIC"
    if(Punctuation.findFirstMatchIn(word) != None) buf += "HAS_PUNCT"

    buf
  }

  def main(args: Array[String]): Unit = {

  }
}