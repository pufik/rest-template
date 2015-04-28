package com.xdev.template.rest.resource;

import java.util.HashSet;
import java.util.Set;

public abstract class Resource {

	private Set<Link> links = new HashSet<>();

	public abstract String getUri();

	public Resource() {
		links.add(new Link(Link.SELF, getUri()));
	}

	public Set<Link> getLinks() {
		return links;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	public void addLink(Link link) {
		this.links.add(link);
	}
}
