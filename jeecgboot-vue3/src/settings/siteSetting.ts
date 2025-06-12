// github repo url
const {
  VITE_GLOB_GITHUB_URL,
  VITE_GLOB_DOC_URL,
  VITE_GLOB_SITE_URL,
  VITE_GLOB_QR_PAGE_DOMAIN,
} = import.meta.env;

export const GITHUB_URL = VITE_GLOB_GITHUB_URL || 'https://github.com/jeecgboot/JeecgBoot';

// vue-Jeecg-admin-next-doc
export const DOC_URL = VITE_GLOB_DOC_URL || 'https://help.jeecg.com';

// site url
export const SITE_URL = VITE_GLOB_SITE_URL || 'http://www.jeecg.com';
// qr page domain
export const QR_PAGE_DOMAIN = VITE_GLOB_QR_PAGE_DOMAIN || 'http://localhost:9000';
