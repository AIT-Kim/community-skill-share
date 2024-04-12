import axios from 'axios';

const api = axios.create({
    baseURL: '/api',
});




api.interceptors.response.use(
    response => {
        return response;
    },
    error => {
        if (error.response.status === 401) {
            throw new Error('Unauthorized');
        }
        return Promise.reject(error);
    }
);

export default api;