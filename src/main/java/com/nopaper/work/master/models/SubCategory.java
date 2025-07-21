package com.nopaper.work.master.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.nopaper.work.master.models.audit.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "subcategory", schema = "npw")
public class SubCategory extends AbstractAuditEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 7351088876837057818L;

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	private UUID id;

	@Column(length = 200, nullable = false, unique = true)
	private String name;

	@Column(length = 5000, nullable = false)
	private String description;

	@Column(length = 50, nullable = false, unique = true)
	private String code;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
			name = "category_subcategory_map",
			joinColumns = @JoinColumn(name = "category_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName="id"))
	private Set<Category> category = new HashSet<>();

	@Type(ListArrayType.class)
	@Column(
	    name = "alias_name",
	    columnDefinition = "text[]"
	)
	private List<String> aliasName;

	@Column
	private UUID categoryId;
}
