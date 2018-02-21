export const isAuthorized = () => localStorage.getItem('isAuthorized') === 'true';
export const isAdmin = () => localStorage.getItem('role') === 'ADMIN';
export const isManager = () => isAdmin() || localStorage.getItem('role') === 'LIBR';