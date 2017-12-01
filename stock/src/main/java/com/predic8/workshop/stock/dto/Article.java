package com.predic8.workshop.stock.dto;

public class Article {

	private String article;
	private long quantity;

	public Article() {
	}

	public String getArticle() {
		return this.article;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Article)) return false;
		final Article other = (Article) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$article = this.getArticle();
		final Object other$article = other.getArticle();
		if (this$article == null ? other$article != null : !this$article.equals(other$article)) return false;
		if (this.getQuantity() != other.getQuantity()) return false;
		return true;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $article = this.getArticle();
		result = result * PRIME + ($article == null ? 43 : $article.hashCode());
		final long $quantity = this.getQuantity();
		result = result * PRIME + (int) ($quantity >>> 32 ^ $quantity);
		return result;
	}

	protected boolean canEqual(Object other) {
		return other instanceof Article;
	}

	public String toString() {
		return "Article(article=" + this.getArticle() + ", quantity=" + this.getQuantity() + ")";
	}
}