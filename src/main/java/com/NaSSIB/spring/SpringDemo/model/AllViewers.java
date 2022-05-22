
package com.NaSSIB.spring.SpringDemo.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AllViewers {

  // not actually a set, in fact a list
  @JsonProperty("viewerSet")
  private List<Viewer> viewerSet = null;

  @JsonProperty("viewerSet")
  public List<Viewer> getViewerSet() {
    return viewerSet;
  }

  @JsonProperty("viewerSet")
  public void setViewerSet(List<Viewer> viewerSet) {
    this.viewerSet = viewerSet;
  }

}
