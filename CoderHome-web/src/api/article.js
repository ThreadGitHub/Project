import request from "@/utils/request";

/**
 * 查询所有文章类别
 * @returns {*}
 */
export function listArticleCategory() {
    return request({
        url: '/api/article-category/list',
        method: 'get'
    });
}

/**
 * 增加文章
 */
export function addArticle(data) {
    return request({
        url: '/api/article',
        method: 'post',
        data
    });
}

/**
 * 文章列表
 * @param data
 * @returns {*}
 */
export function listArticle(articleCategory, count, addNum) {
    return request({
        url: `/api/article?addNum=${addNum}&articleCategory=${articleCategory}&count=${count}`,
        method: 'get'
    });
}
