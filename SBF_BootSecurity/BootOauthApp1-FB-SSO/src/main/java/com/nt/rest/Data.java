package com.nt.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class Address {
	public Object formatted;
	public Object streetAddress;
	public Object locality;
	public Object region;
	public Object postalCode;
	public Object country;
}

class Attributes {
	public String at_hash;
	public String sub;
	public boolean email_verified;
	public String iss;
	public String given_name;
	public String nonce;
	public String picture;
	public ArrayList<String> aud;
	public String azp;
	public String name;
	public Date exp;
	public String family_name;
	public Date iat;
	public String email;
}

class Authority {
	public String authority;
	public Attributes attributes;
	public IdToken idToken;
	public Object userInfo;
}

class Claims {
	public String at_hash;
	public String sub;
	public boolean email_verified;
	public String iss;
	public String given_name;
	public String nonce;
	public String picture;
	public ArrayList<String> aud;
	public String azp;
	public String name;
	public Date exp;
	public String family_name;
	public Date iat;
	public String email;
}

class Details {
	public String remoteAddress;
	public String sessionId;
}

class IdToken {
	public String tokenValue;
	public Date issuedAt;
	public Date expiresAt;
	public Claims claims;
	public Object authenticationContextClass;
	public Object authorizationCodeHash;
	public Object authenticationMethods;
	public String subject;
	public String authorizedParty;
	public String issuer;
	public ArrayList<String> audience;
	public String nonce;
	public String accessTokenHash;
	public Object authenticatedAt;
	public Object profile;
	public Object preferredUsername;
	public Object phoneNumberVerified;
	public Address address;
	public String fullName;
	public Object zoneInfo;
	public Object locale;
	public String givenName;
	public String familyName;
	public Object middleName;
	public Object nickName;
	public Object phoneNumber;
	public Object website;
	public Object birthdate;
	public boolean emailVerified;
	public String email;
	public Object updatedAt;
	public String picture;
	public Object gender;
}

class Principal {
	public ArrayList<Authority> authorities;
	public Attributes attributes;
	public IdToken idToken;
	public Object userInfo;
	public Claims claims;
	public String name;
	public Date expiresAt;
	public Object authenticationContextClass;
	public Object authorizationCodeHash;
	public Object authenticationMethods;
	public String subject;
	public String authorizedParty;
	public String issuer;
	public ArrayList<String> audience;
	public String nonce;
	public Date issuedAt;
	public String accessTokenHash;
	public Object authenticatedAt;
	public Object profile;
	public Object preferredUsername;
	public Object phoneNumberVerified;
	public Address address;
	public String fullName;
	public Object zoneInfo;
	public Object locale;
	public String givenName;
	public String familyName;
	public Object middleName;
	public Object nickName;
	public Object phoneNumber;
	public Object website;

	public ArrayList<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(ArrayList<Authority> authorities) {
		this.authorities = authorities;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public IdToken getIdToken() {
		return idToken;
	}

	public void setIdToken(IdToken idToken) {
		this.idToken = idToken;
	}

	public Object getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Object userInfo) {
		this.userInfo = userInfo;
	}

	public Claims getClaims() {
		return claims;
	}

	public void setClaims(Claims claims) {
		this.claims = claims;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Object getAuthenticationContextClass() {
		return authenticationContextClass;
	}

	public void setAuthenticationContextClass(Object authenticationContextClass) {
		this.authenticationContextClass = authenticationContextClass;
	}

	public Object getAuthorizationCodeHash() {
		return authorizationCodeHash;
	}

	public void setAuthorizationCodeHash(Object authorizationCodeHash) {
		this.authorizationCodeHash = authorizationCodeHash;
	}

	public Object getAuthenticationMethods() {
		return authenticationMethods;
	}

	public void setAuthenticationMethods(Object authenticationMethods) {
		this.authenticationMethods = authenticationMethods;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthorizedParty() {
		return authorizedParty;
	}

	public void setAuthorizedParty(String authorizedParty) {
		this.authorizedParty = authorizedParty;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public ArrayList<String> getAudience() {
		return audience;
	}

	public void setAudience(ArrayList<String> audience) {
		this.audience = audience;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public String getAccessTokenHash() {
		return accessTokenHash;
	}

	public void setAccessTokenHash(String accessTokenHash) {
		this.accessTokenHash = accessTokenHash;
	}

	public Object getAuthenticatedAt() {
		return authenticatedAt;
	}

	public void setAuthenticatedAt(Object authenticatedAt) {
		this.authenticatedAt = authenticatedAt;
	}

	public Object getProfile() {
		return profile;
	}

	public void setProfile(Object profile) {
		this.profile = profile;
	}

	public Object getPreferredUsername() {
		return preferredUsername;
	}

	public void setPreferredUsername(Object preferredUsername) {
		this.preferredUsername = preferredUsername;
	}

	public Object getPhoneNumberVerified() {
		return phoneNumberVerified;
	}

	public void setPhoneNumberVerified(Object phoneNumberVerified) {
		this.phoneNumberVerified = phoneNumberVerified;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Object getZoneInfo() {
		return zoneInfo;
	}

	public void setZoneInfo(Object zoneInfo) {
		this.zoneInfo = zoneInfo;
	}

	public Object getLocale() {
		return locale;
	}

	public void setLocale(Object locale) {
		this.locale = locale;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Object getMiddleName() {
		return middleName;
	}

	public void setMiddleName(Object middleName) {
		this.middleName = middleName;
	}

	public Object getNickName() {
		return nickName;
	}

	public void setNickName(Object nickName) {
		this.nickName = nickName;
	}

	public Object getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Object phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Object getWebsite() {
		return website;
	}

	public void setWebsite(Object website) {
		this.website = website;
	}

	public Object getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Object birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Object updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Object getGender() {
		return gender;
	}

	public void setGender(Object gender) {
		this.gender = gender;
	}
	public Object birthdate;
	public boolean emailVerified;
	public String email;
	public Object updatedAt;
	public String picture;
	public Object gender;
}

class Custom extends OAuth2AuthenticationToken implements Serializable {

	public Custom(OAuth2User principal, Collection<? extends GrantedAuthority> authorities,
			String authorizedClientRegistrationId) {
		super(principal, authorities, authorizedClientRegistrationId);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Collection<? extends GrantedAuthority> authorities;
	public Details details;
	public boolean authenticated;
	public Principal principal;
	public String authorizedClientRegistrationId;
	public String credentials;
	public String name;

	public Collection<GrantedAuthority> getAuthorities() {
		return (Collection<GrantedAuthority>) authorities;
	}

	public void setAuthorities(ArrayList<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public OAuth2User getPrincipal() {
		return (OAuth2User) principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public String getAuthorizedClientRegistrationId() {
		return authorizedClientRegistrationId;
	}

	public void setAuthorizedClientRegistrationId(String authorizedClientRegistrationId) {
		this.authorizedClientRegistrationId = authorizedClientRegistrationId;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
