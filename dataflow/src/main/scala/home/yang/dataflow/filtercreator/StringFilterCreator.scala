package home.yang.dataflow.filtercreator

import home.yang.dataflow.filter.StringFilter
import home.yang.dataflow.{Filter, FilterCreator}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class StringFilterCreator extends FilterCreator{

  override def create(key: String, value: String, func: String): Filter[String] = {
   val isPass=FilterFunc.passFun(func,value)
    new StringFilter(key,isPass)
  }
//  val simpleFilter="$e=='ff'"
//  val filterExample="($.header.fixed_header.event_type.domain_name=='32.303 V6.3' or ($.header.fixed_header.event_type.domain_name=='32.111 V6.2') or $.header.fixed_header.event_type.domain_name=='32.603 V6.3.1' or $.header.fixed_header.event_type.domain_name=='32.346-A V10.0' or $.header.fixed_header.event_type.domain_name=='32.363 V6.3' or $.header.fixed_header.event_type.domain_name=='32.663 V6.4' or $.header.fixed_header.event_type.domain_name=='32.353 V6.2') "
}


