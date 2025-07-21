
    create table npw.category (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.city (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        pin varchar(10),
        id uuid not null,
        state_id uuid,
        code varchar(50) not null unique,
        telephone_code varchar(50) not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.consent (
        consent_effective_date timestamp(6) with time zone not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        consent_version varchar(10),
        id uuid not null,
        consent_module varchar(50) not null,
        consent_short varchar(200) not null,
        consent_description varchar(5000),
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.country (
        telephone_code varchar(5) not null unique,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        currency_id uuid,
        id uuid not null,
        time_zone_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.currency (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.grade_system (
        max_score integer not null,
        max_score_weightage integer not null,
        min_score integer not null,
        min_score_weightage integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        scoring_system varchar(50) not null check (scoring_system in ('ABSOLUTE_SCORE','PERCENTILE','PERCENTAGE','PERCENT_RANGE','GRADE_LETTER','GRADE_POINT','PERFORMANCE_REMARK','ABSOLUTE_RANGE')),
        status varchar(50) not null,
        value jsonb not null,
        primary key (id)
    );

    create table npw.income_band (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        currency_id uuid,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        payment_frequency text[],
        range text[],
        primary key (id)
    );

    create table npw.language (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.locality (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        city_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.product (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        sub_category_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.product_specification (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        product_id uuid,
        code varchar(50) not null,
        name varchar(200) not null,
        value varchar(300) not null,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id),
        unique (name),
        unique (code)
    );

    create table npw.relations (
        is_immediate boolean default true not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        description varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(50) not null check (name in ('SELF','FATHER','MOTHER','LEGAL_GUARDIAN','GRAND_FATHER','GRAND_MOTHER','UNCLE','AUNTY','SISTER','BROTHER','GUARDIAN','FRIEND','NIECE','NEPHEW','SON','DAUGHTER','GRAND_SON','GRAND_DAUGHTER','COUSIN','OTHERS')),
        status varchar(50) not null,
        primary key (id),
        unique (name)
    );

    create table npw.state (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.subcategory (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        category_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.time_zone (
        difference integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null,
        name varchar(200) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        zone varchar(50) not null check (zone in ('SOUTH_ASIA','MENA','WEST_AFRICA')),
        alias_name text[],
        primary key (id)
    );

    create table npw.type_of_profession (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(100) not null,
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.type_of_service (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(100) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.unit (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        standard varchar(50) not null check (standard in ('METRIC','BRITISH')),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.category_subcategory_map (
        category_id uuid not null,
        subcategory_id uuid not null,
        primary key (category_id, subcategory_id)
    );

    create table npw.subcategory_product_map (
        product_id uuid not null,
        subcategory_id uuid not null,
        primary key (product_id, subcategory_id)
    );

    alter table if exists npw.category_subcategory_map 
       add constraint FKbelm8ix2klulegnuc2wk4ufch 
       foreign key (subcategory_id) 
       references npw.category;

    alter table if exists npw.category_subcategory_map 
       add constraint FKbk0vmfksrdwbuwlyx5u35gnj0 
       foreign key (category_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKr511i87tiybm4cxcge7ptx0be 
       foreign key (product_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKavcfmivx0o53or215bsvrkt2w 
       foreign key (subcategory_id) 
       references npw.product;

    create table npw.category (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.city (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        pin varchar(10),
        id uuid not null,
        state_id uuid,
        code varchar(50) not null unique,
        telephone_code varchar(50) not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.consent (
        consent_effective_date timestamp(6) with time zone not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        consent_version varchar(10),
        id uuid not null,
        consent_module varchar(50) not null,
        consent_short varchar(200) not null,
        consent_description varchar(5000),
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.country (
        telephone_code varchar(5) not null unique,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        currency_id uuid,
        id uuid not null,
        time_zone_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.currency (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.grade_system (
        max_score integer not null,
        max_score_weightage integer not null,
        min_score integer not null,
        min_score_weightage integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        scoring_system varchar(50) not null check (scoring_system in ('ABSOLUTE_SCORE','PERCENTILE','PERCENTAGE','PERCENT_RANGE','GRADE_LETTER','GRADE_POINT','PERFORMANCE_REMARK','ABSOLUTE_RANGE')),
        status varchar(50) not null,
        value jsonb not null,
        primary key (id)
    );

    create table npw.income_band (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        currency_id uuid,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        payment_frequency text[],
        range text[],
        primary key (id)
    );

    create table npw.language (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.locality (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        city_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.product (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        sub_category_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.product_specification (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        product_id uuid,
        code varchar(50) not null,
        name varchar(200) not null,
        value varchar(300) not null,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id),
        unique (name),
        unique (code)
    );

    create table npw.relations (
        is_immediate boolean default true not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        description varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(50) not null check (name in ('SELF','FATHER','MOTHER','LEGAL_GUARDIAN','GRAND_FATHER','GRAND_MOTHER','UNCLE','AUNTY','SISTER','BROTHER','GUARDIAN','FRIEND','NIECE','NEPHEW','SON','DAUGHTER','GRAND_SON','GRAND_DAUGHTER','COUSIN','OTHERS')),
        status varchar(50) not null,
        primary key (id),
        unique (name)
    );

    create table npw.state (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.subcategory (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        category_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.time_zone (
        difference integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null,
        name varchar(200) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        zone varchar(50) not null check (zone in ('SOUTH_ASIA','MENA','WEST_AFRICA')),
        alias_name text[],
        primary key (id)
    );

    create table npw.type_of_profession (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(100) not null,
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.type_of_service (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(100) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.unit (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        standard varchar(50) not null check (standard in ('METRIC','BRITISH')),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.category_subcategory_map (
        category_id uuid not null,
        subcategory_id uuid not null,
        primary key (category_id, subcategory_id)
    );

    create table npw.subcategory_product_map (
        product_id uuid not null,
        subcategory_id uuid not null,
        primary key (product_id, subcategory_id)
    );

    alter table if exists npw.category_subcategory_map 
       add constraint FKbelm8ix2klulegnuc2wk4ufch 
       foreign key (subcategory_id) 
       references npw.category;

    alter table if exists npw.category_subcategory_map 
       add constraint FKbk0vmfksrdwbuwlyx5u35gnj0 
       foreign key (category_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKr511i87tiybm4cxcge7ptx0be 
       foreign key (product_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKavcfmivx0o53or215bsvrkt2w 
       foreign key (subcategory_id) 
       references npw.product;

    create table npw.category (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.city (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        pin varchar(10),
        id uuid not null,
        state_id uuid,
        code varchar(50) not null unique,
        telephone_code varchar(50) not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.consent (
        consent_effective_date timestamp(6) with time zone not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        consent_version varchar(10),
        id uuid not null,
        consent_module varchar(50) not null,
        consent_short varchar(200) not null,
        consent_description varchar(5000),
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.country (
        telephone_code varchar(5) not null unique,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        currency_id uuid,
        id uuid not null,
        time_zone_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.currency (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.grade_system (
        max_score integer not null,
        max_score_weightage integer not null,
        min_score integer not null,
        min_score_weightage integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        scoring_system varchar(50) not null check (scoring_system in ('ABSOLUTE_SCORE','PERCENTILE','PERCENTAGE','PERCENT_RANGE','GRADE_LETTER','GRADE_POINT','PERFORMANCE_REMARK','ABSOLUTE_RANGE')),
        status varchar(50) not null,
        value jsonb not null,
        primary key (id)
    );

    create table npw.income_band (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        currency_id uuid,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        payment_frequency text[],
        range text[],
        primary key (id)
    );

    create table npw.language (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.locality (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        city_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.product (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        sub_category_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.product_specification (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        product_id uuid,
        code varchar(50) not null,
        name varchar(200) not null,
        value varchar(300) not null,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id),
        unique (name),
        unique (code)
    );

    create table npw.relations (
        is_immediate boolean default true not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        description varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(50) not null check (name in ('SELF','FATHER','MOTHER','LEGAL_GUARDIAN','GRAND_FATHER','GRAND_MOTHER','UNCLE','AUNTY','SISTER','BROTHER','GUARDIAN','FRIEND','NIECE','NEPHEW','SON','DAUGHTER','GRAND_SON','GRAND_DAUGHTER','COUSIN','OTHERS')),
        status varchar(50) not null,
        primary key (id),
        unique (name)
    );

    create table npw.state (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.subcategory (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        category_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.time_zone (
        difference integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null,
        name varchar(200) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        zone varchar(50) not null check (zone in ('SOUTH_ASIA','MENA','WEST_AFRICA')),
        alias_name text[],
        primary key (id)
    );

    create table npw.type_of_profession (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(100) not null,
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.type_of_service (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(100) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.unit (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        standard varchar(50) not null check (standard in ('METRIC','BRITISH')),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.category_subcategory_map (
        category_id uuid not null,
        subcategory_id uuid not null,
        primary key (category_id, subcategory_id)
    );

    create table npw.subcategory_product_map (
        product_id uuid not null,
        subcategory_id uuid not null,
        primary key (product_id, subcategory_id)
    );

    alter table if exists npw.category_subcategory_map 
       add constraint FKbelm8ix2klulegnuc2wk4ufch 
       foreign key (subcategory_id) 
       references npw.category;

    alter table if exists npw.category_subcategory_map 
       add constraint FKbk0vmfksrdwbuwlyx5u35gnj0 
       foreign key (category_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKr511i87tiybm4cxcge7ptx0be 
       foreign key (product_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKavcfmivx0o53or215bsvrkt2w 
       foreign key (subcategory_id) 
       references npw.product;

    create table npw.category (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.city (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        pin varchar(10),
        id uuid not null,
        state_id uuid,
        code varchar(50) not null unique,
        telephone_code varchar(50) not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.consent (
        consent_effective_date timestamp(6) with time zone not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        consent_version varchar(10),
        id uuid not null,
        consent_module varchar(50) not null,
        consent_short varchar(200) not null,
        consent_description varchar(5000),
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.country (
        telephone_code varchar(5) not null unique,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        currency_id uuid,
        id uuid not null,
        time_zone_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.currency (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.grade_system (
        max_score integer not null,
        max_score_weightage integer not null,
        min_score integer not null,
        min_score_weightage integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        scoring_system varchar(50) not null check (scoring_system in ('ABSOLUTE_SCORE','PERCENTILE','PERCENTAGE','PERCENT_RANGE','GRADE_LETTER','GRADE_POINT','PERFORMANCE_REMARK','ABSOLUTE_RANGE')),
        status varchar(50) not null,
        value jsonb not null,
        primary key (id)
    );

    create table npw.income_band (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        currency_id uuid,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        payment_frequency text[],
        range text[],
        primary key (id)
    );

    create table npw.language (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.locality (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        city_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.product (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        sub_category_id uuid,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.product_specification (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        product_id uuid,
        code varchar(50) not null,
        name varchar(200) not null,
        value varchar(300) not null,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id),
        unique (name),
        unique (code)
    );

    create table npw.relations (
        is_immediate boolean default true not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        description varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(50) not null check (name in ('SELF','FATHER','MOTHER','LEGAL_GUARDIAN','GRAND_FATHER','GRAND_MOTHER','UNCLE','AUNTY','SISTER','BROTHER','GUARDIAN','FRIEND','NIECE','NEPHEW','SON','DAUGHTER','GRAND_SON','GRAND_DAUGHTER','COUSIN','OTHERS')),
        status varchar(50) not null,
        primary key (id),
        unique (name)
    );

    create table npw.state (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        country_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.subcategory (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        category_id uuid,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.time_zone (
        difference integer not null,
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null,
        name varchar(200) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        zone varchar(50) not null check (zone in ('SOUTH_ASIA','MENA','WEST_AFRICA')),
        alias_name text[],
        primary key (id)
    );

    create table npw.type_of_profession (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        name varchar(100) not null,
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.type_of_service (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        name varchar(100) not null unique,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        status varchar(50) not null,
        primary key (id)
    );

    create table npw.unit (
        created_date timestamp(6) with time zone not null,
        last_modified_date timestamp(6) with time zone,
        id uuid not null,
        code varchar(50) not null unique,
        name varchar(200) not null unique,
        description varchar(5000) not null,
        created_by varchar(200) not null,
        last_modified_by varchar(200),
        standard varchar(50) not null check (standard in ('METRIC','BRITISH')),
        status varchar(50) not null,
        alias_name text[],
        primary key (id)
    );

    create table npw.category_subcategory_map (
        category_id uuid not null,
        subcategory_id uuid not null,
        primary key (category_id, subcategory_id)
    );

    create table npw.subcategory_product_map (
        product_id uuid not null,
        subcategory_id uuid not null,
        primary key (product_id, subcategory_id)
    );

    alter table if exists npw.category_subcategory_map 
       add constraint FKbelm8ix2klulegnuc2wk4ufch 
       foreign key (subcategory_id) 
       references npw.category;

    alter table if exists npw.category_subcategory_map 
       add constraint FKbk0vmfksrdwbuwlyx5u35gnj0 
       foreign key (category_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKr511i87tiybm4cxcge7ptx0be 
       foreign key (product_id) 
       references npw.subcategory;

    alter table if exists npw.subcategory_product_map 
       add constraint FKavcfmivx0o53or215bsvrkt2w 
       foreign key (subcategory_id) 
       references npw.product;
