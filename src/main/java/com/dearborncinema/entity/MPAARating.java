package com.dearborncinema.entity;

/**
 * Represents a rating by the Motion Picture Association of America (MPAA).
 * @author Alonso del Arte
 */
public enum MPAARating {

    /**
     * General audiences. This rating is mostly used for children's movies.
     */
    G,

    /**
     * Mature audiences. Most movies originally issued this rating have been
     * changed over to PG.
     * @deprecated Use {@link #PG}, {@link #PG13}, {@link #R} or {@link #NC17}
     * instead.
     */
    @Deprecated
    M,

    /**
     * General audiences, parental guidance suggested. This was changed over to
     * PG in 1972.
     * @deprecated Use Use {@link #PG} or {@link #PG13} instead.
     */
    @Deprecated
    GP,

    /**
     * Parental guidance suggested. This rating has been issued to movies since
     * 1969. Often a reason's given for the rating. For example, <i>The Parent
     * Trap</i> is rated PG "for some mild mischief."
     */
    PG,

    /**
     * Parental guidance strongly suggested. This rating has been issued to
     * movies since 1984. Often a reason's given for the rating. For example,
     * <i>Inception</i> is rated PG-13 "for sequences of violence and action
     * throughout."
     */
    PG13,

    /**
     * Restricted audiences, minors require parent or guardian to come along.
     * Often a reason's given for the rating. For example, both <i>Ted</i> and
     * <i>Ted 2</i> are rated R "for crude and sexual content, pervasive
     * language, and some drug use."
     */
    R,

    /**
     * No one 17-years-old or under admitted. This rating was issued as recently
     * as 1989. Some movies given this rating were retroactively re-rated NC-17.
     * @deprecated Use {@link #NC17} instead.
     */
    @Deprecated
    X,

    /**
     * No one 17-years-old or under admitted. This rating has been issued to
     * movies since 1990. <i>Henry &amp; June</i>, released on October 5, 1990,
     * was the first movie to be given this rating. According to the MPAA, the
     * NC-17 rating "does not mean 'obscene' or 'pornographic' in the common or
     * legal meaning of those words, and should not be construed as a negative
     * judgment in any sense. The rating simply signals that the content is
     * appropriate only for an adult audience." Because ads for X-rated movies
     * were rejected by TV and radio stations, and Blockbuster (remember
     * Blockbuster?) refused to carry X-rated movies, a new rating was needed
     * for movies considered to have serious artistic merit despite explicit
     * sexual content. Even so, filmmakers can appeal an NC-17 rating. If the
     * MPAA is satisfied with a re-edit, the rating might be downgraded to R.
     * Either way, an explanation for the rating is usually given. For example,
     * <i>Blue Is the Warmest Colour</i> is rated NC-17 "for explicit sexual
     * content."
     */
    NC17,

    /**
     * This film has not been rated by the MPAA. It could be a foreign film that
     * hasn't been submitted to the MPAA, or, less likely, it could be that the
     * MPAA has not gotten around to giving this film a rating. Generally
     * American theater owners don't screen movies that have not been rated by
     * the MPAA, so Hollywood films are almost always rated by the MPAA prior to
     * release.
     */
    UNRATED

}
