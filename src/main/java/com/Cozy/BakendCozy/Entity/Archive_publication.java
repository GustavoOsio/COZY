package com.Cozy.BakendCozy.Entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "ARCHIVE_PUBLICATION")
public class Archive_publication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	    @Column(name = "publication_id")
	      private int publicationId;

	    @Column(name = "archive_id")
	    private int archiveId;

	    @Column(name = "comment", columnDefinition = "text")
	    private String comment;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getPublicationId() {
			return publicationId;
		}

		public void setPublicationId(int publicationId) {
			this.publicationId = publicationId;
		}

		public int getArchiveId() {
			return archiveId;
		}

		public void setArchiveId(int archiveId) {
			this.archiveId = archiveId;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
	    
	    

}
