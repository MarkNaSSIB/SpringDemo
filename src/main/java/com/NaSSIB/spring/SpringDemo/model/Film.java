/**
 * 
 */
package com.NaSSIB.spring.SpringDemo.model;

/**
 * @author Boutros
 * 
 */
public class Film {
  /**
   * @param filmTitle
   * @param runTime
   * @param releaseDate
   * @param filmCreator
   */
  public Film(String filmTitle, int runTime, String releaseDate, String filmCreator) {
    // super();
    this.filmTitle = filmTitle;
    this.runTime = runTime;
    this.releaseDate = releaseDate;
    this.filmCreator = filmCreator;
  }

  private String filmTitle;
  private int runTime;
  private String releaseDate;
  private String filmCreator;

  /**
   * @return the filmTitle
   */
  public String getFilmTitle() {
    return filmTitle;
  }

  /**
   * @param filmTitle the filmTitle to set
   */
  public void setFilmTitle(String filmTitle) {
    this.filmTitle = filmTitle;
  }

  /**
   * @return the runTime
   */
  public int getRunTime() {
    return runTime;
  }

  /**
   * @param runTime the runTime to set
   */
  public void setRunTime(int runTime) {
    this.runTime = runTime;
  }

  /**
   * @return the releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param releaseDate the releaseDate to set
   */
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public String toString() {
    return "Film [Title=" + filmTitle + ", Release Date=" + releaseDate + "]";
  }

  /**
   * @return the filmCreator
   */
  public String getFilmCreator() {
    return filmCreator;
  }

  /**
   * @param filmCreator the filmCreator to set
   */
  public void setFilmCreator(String filmCreator) {
    this.filmCreator = filmCreator;
  }

}
