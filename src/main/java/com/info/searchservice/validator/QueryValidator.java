package com.info.searchservice.validator;

import java.util.IllegalFormatException;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class QueryValidator {
  @Value("${query.expectedFields}")
  private List<String> expectedFields;

  public void validate(String query){
    if(StringUtils.isEmpty(query)){
      throw new IllegalArgumentException("query is mandatory request parameter");
    }
    //here regx can be used to validate the format
    if(!query.contains(":")){
      throw new MissingFormatArgumentException("query field is expect in format language:<coding lang>. Examples language:go, language:js");
    }

    String[] query_args = query.split(":");
    if(query_args.length < 2 || !expectedFields.contains(query_args[0]) ){
      throw new MissingFormatArgumentException("query field is expect in format 'language:coding_lang'. Examples language:go, language:js");
    }
  }
}
