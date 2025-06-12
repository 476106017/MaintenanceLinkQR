# 白标处理说明

本文档介绍如何通过环境变量自定义系统的品牌信息，实现白标化部署。

1. 修改 `jeecgboot-vue3/.env` 文件中的以下配置：
   ```
   VITE_GLOB_APP_TITLE=WhiteLabel 企业级低代码平台
   VITE_GLOB_APP_SHORT_NAME=WhiteLabel_Pro
  VITE_GLOB_GITHUB_URL=https://example.com
  VITE_GLOB_DOC_URL=https://example.com/help
  VITE_GLOB_SITE_URL=https://example.com
  VITE_GLOB_QR_PAGE_DOMAIN=http://localhost:9000
  ```
2. 根据需要替换 `jeecgboot-vue3/public` 目录下的 logo 等图片资源。
3. 重新编译前端并部署，即可看到去品牌化后的界面。
