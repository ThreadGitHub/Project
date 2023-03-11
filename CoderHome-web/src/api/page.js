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
