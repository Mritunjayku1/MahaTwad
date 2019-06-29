package com.water.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table(name="Message")
public class Message  implements Serializable{

/**
 * 
 */
	

			
private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "MSG_ID", unique = true, nullable = false, precision = 10, scale = 0)
private Integer msgId;


@Column(name = "MSG_TYPE", length = 100)
private Integer  msgType;


@Column(name = "MSG_TMP", length = 100)
private Integer  msgTmp;


@Temporal(TemporalType.TIMESTAMP)
@Column(name = "SENDER_TS", nullable = false, length = 26)
private Date senderTs;



@Column(name = "STATUS_FLAG", length = 1)
private Character statusFlag;




@Temporal(TemporalType.TIMESTAMP)
@Column(name = "CREATE_TS", nullable = false, length = 26)
private Date createTs;


@Column(name = "CREATE_USERID", nullable = false, length = 30)
private String createUserId;


@Temporal(TemporalType.TIMESTAMP)
@Column(name = "UPDATE_TS", nullable = false, length = 26)
private Date updateTs;


@Column(name = "UPDATE_USERID", nullable = false, length = 30)
private String updateUserId;


}
