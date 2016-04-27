package yang.flexmapping.getval

import com.nsn.oss.nbi.flexmapping.EventField

import scala.xml.NodeSeq

/**
  * Created by y28yang on 4/9/2016.
  */
trait GetValue {
  def getValue(event: java.util.Map[EventField, String]):String
}

object GetValue{



  def getValSeq(tagNode: NodeSeq):Seq[GetValue]={
    val seqGetVal=tagNode.map(it=>{
      it.label match {
        case "fromEvent"=> new GetValFromEvent(it \@ "attributeName")
        case "fixedValue"=> new GetValFixedVal(it.text)
      }})
    seqGetVal
  }

   def parse(tagNode: NodeSeq): GetValue ={
     val children=tagNode \ "_"
     val seqGetVal=getValSeq(children)
     seqGetVal.length match {
       case 1=> seqGetVal.head
       case 0=> throw new IllegalArgumentException("can not parse fromEvent or fixedValue:"+tagNode.toString())
       case _=>  new GetValFromMulti(seqGetVal)
     }
   }

}